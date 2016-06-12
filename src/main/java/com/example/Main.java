package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int ROW = 3;
    public static int COLUMN = 3;
    public static final int MAX_NEIGHBOR = 3;
    private static final int INPUT_LENGTH_INVALID = 1;
    private static final int INPUT_VALUE_INVALID = 2;

    private static int[] sumOtherPath = new int[2];
    private static int[][] arrayPath;

    public static void main(String[] args) throws IOException {
        inputArray();
        int[] pos;
        int[] posNext = new int[1];
        int[] posPrev;
        HashMap<Integer, Integer> posPassed = new HashMap<>();

        pos = findPosNumberLargestByColumn(arrayPath, 0);
        posPrev = pos;
        int sumScore = 0;
        boolean flagGoUpOrDow = false;
        int[] highestScore = findHighestScore(arrayPath, pos, posPrev, posNext, sumScore, flagGoUpOrDow, posPassed);
        int finalScore = highestScore[1] == 1 ? highestScore[0] : -1;
        System.out.println("Highest way: " + finalScore);
    }


    private static int[] findHighestScore(int[][] array, int[] pos, int[] posPrev, int[] posNext, int sum, boolean flagGoUpOrDow, HashMap<Integer, Integer> posPassed){
        do {
            int[][] posNumberNeighbor = findPosNumberNeighbor(pos, posPrev, posPassed);
            try {
                posNext = findPosNumberLargestByNeighbor(posNumberNeighbor, array);
            } catch (NullPointerException e) {
                System.out.println("Neighbors not found");
                return new int[]{sum += array[pos[0]][pos[1]], isSnakeCanReachRightSide(pos) ? 1 : 0 };
            }
            flagGoUpOrDow = checkGoUpOrGoDown(pos, posNext);

            if(flagGoUpOrDow){
                sum += array[pos[0]][pos[1]];
                int[] posNextOtherPath = new int[2];
                try {
                    if(posNumberNeighbor.length == 1){
                        sum = sum > array[posNumberNeighbor[0][0]][posNumberNeighbor[0][1]] ? sum : array[posNumberNeighbor[0][0]][posNumberNeighbor[0][1]];
                        if(sum > sumOtherPath[0]){
                            return new int[]{sum, isSnakeCanReachRightSide(pos) ? 1 : 0};
                        } else {
                            return sumOtherPath;
                        }
                    } else {
                        posNextOtherPath = findPosNumberNextToLargestByNeighbor(posNumberNeighbor.clone(), array, posNext);
                    }
                } catch (NullPointerException e){
                    System.out.println("Neighbors not found by findPosNumberNextToLargestByNeighbor ");
                    return new int[]{sum, isSnakeCanReachRightSide(pos) ? 1 : 0};
                }
                if(array[posNextOtherPath[0]][posNextOtherPath[1]] == -1){
                    if(sum > sumOtherPath[0]){
                        return new int[]{sum, isSnakeCanReachRightSide(pos) ? 1 : 0};
                    } else {
                        return sumOtherPath;
                    }
                }
                int[] posPrevNewPath = pos;
                int[] posNewPath = posNextOtherPath;
                HashMap<Integer, Integer> posPassedNewPath = new HashMap<>();
                posPassedNewPath.put(posNewPath[0], posNewPath[1]);
                sumOtherPath[0] = 0;
                int[] highestScore = findHighestScore(array, posNewPath, posPrevNewPath, posNextOtherPath, sum, false, posPassedNewPath);
                sumOtherPath[0] = sumOtherPath[0] > highestScore[0] ?  sumOtherPath[0] :  highestScore[0];
                sumOtherPath[1] = highestScore[1];
                sum = 0;
            } else {
                sum += array[pos[0]][pos[1]];
            }
            posPrev = pos;
            posPassed.put(pos[0], pos[1]);
            pos = posNext;
        } while (array[posNext[0]][posNext[1]] != -1 && pos[1] <= COLUMN);
        if(sum > sumOtherPath[0]){
            return new int[]{sum, isSnakeCanReachRightSide(pos) ? 1 : 0};
        } else {
            return sumOtherPath;
        }
    }

    private static void inputArray() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("Input row and column of array");
            String[] line = input.readLine().split(" ");
            if (line.length != 2){
                System.exit(INPUT_LENGTH_INVALID);
            }
            ROW = Integer.parseInt(line[0]) - 1;
            COLUMN  = Integer.parseInt(line[1]) - 1;
        } while (ROW < 1 || ROW > 500 || COLUMN < 1 || COLUMN > 500);
        arrayPath = new int[ROW+1][COLUMN+1];
        for (int i = 0; i <= ROW; i++) {
            String[] line = input.readLine().split(" ");
            if (line.length - 1 == COLUMN){
                for (int j = 0; j <= COLUMN; j++) {
                    int valueInt = Integer.parseInt(line[j]);
                    if(valueInt < -1 || valueInt > 99999){
                        System.exit(INPUT_VALUE_INVALID);
                    }
                    arrayPath[i][j] = valueInt;
                }
            } else {
                System.out.println("Input not right");
                System.exit(INPUT_LENGTH_INVALID);
            }
        }
    }

    private static boolean isSnakeCanReachRightSide(int[] pos) {
        if(pos[1] == COLUMN){
            return true;
        } else {
            return false;
        }
    }

    private static int[] findPosNumberNextToLargestByNeighbor(int[][] posNumberNeighbor, int[][] array, int[] maxOfNeighbor) throws NullPointerException {
        if(posNumberNeighbor.length-1 == 0){
            throw new NullPointerException();
        }
        int[][] cloneNeighbor = removePositionDuplicated(posNumberNeighbor, maxOfNeighbor);
        return findPosNumberLargestByNeighbor(cloneNeighbor, array);
    }

    private static int[][] removePositionDuplicated(int[][] posNeededCheck, int[] posNeededRemove) {
        int[][] posReturn = new int[posNeededCheck.length-1][2];
        boolean flagMove = false;
        for (int i = 0; i < posNeededCheck.length; i++) {
            if((posNeededCheck[i][0] == posNeededRemove[0]) && (posNeededCheck[i][1] == posNeededRemove[1])) {
                if(i + 1 < posNeededCheck.length) {
                    posNeededCheck[i][0] = posNeededCheck[i + 1][0];
                    posNeededCheck[i][1] = posNeededCheck[i + 1][1];
                    flagMove = true;
                }
            } else {
                if (flagMove && i + 1 < posNeededCheck.length){
                    posNeededCheck[i][0] = posNeededCheck[i + 1][0];
                    posNeededCheck[i][1] = posNeededCheck[i + 1][1];
                }
            }
        }
        for (int i = 0; i < posReturn.length; i++) {
            posReturn[i][0] = posNeededCheck[i][0];
            posReturn[i][1] = posNeededCheck[i][1];
        }
        return posReturn;
    }

    private static boolean checkGoUpOrGoDown(int[] pos, int[] posNext) {
        if (pos[0] - ROW == posNext[0] || pos[0] + ROW == posNext[0]) {
            return true;
        }
        return false;
    }

    private static int[] findPosNumberLargestByNeighbor(int[][] posNumberNeighbor, int[][] array) throws NullPointerException {
        if(posNumberNeighbor == null || posNumberNeighbor.length == 0){
            throw new NullPointerException();
        }
        int max = array[posNumberNeighbor[0][0]][posNumberNeighbor[0][1]];
        int posX = posNumberNeighbor[0][0], posY = posNumberNeighbor[0][1];
        for (int i = 1; i < posNumberNeighbor.length; i++) {
            if (array[posNumberNeighbor[i][0]][posNumberNeighbor[i][1]] == -1) {
                continue;
            }
            if (max < array[posNumberNeighbor[i][0]][posNumberNeighbor[i][1]]) {
                max = array[posNumberNeighbor[i][0]][posNumberNeighbor[i][1]];
                posX = posNumberNeighbor[i][0];
                posY = posNumberNeighbor[i][1];
            }
        }
        return new int[]{posX, posY};
    }

    private static int[][] findPosNumberNeighbor(int[] pos, int[] posPrev, HashMap<Integer, Integer> posPassed) {
        int[][] neighbors;
        if (pos[0] == 0 && pos[1] == 0) {
            neighbors = new int[MAX_NEIGHBOR - 1][2];
            neighbors[0][0] = pos[0] + 1 == posPrev[0] ? pos[0] + ROW : pos[0] + 1;
            neighbors[0][1] = pos[1];
            neighbors[1][0] = pos[0];
            neighbors[1][1] = pos[1] + 1;
        } else if (pos[0] == ROW && pos[1] == 0) {
            if (pos[0] == posPrev[0] && pos[1] == posPrev[1]) {
                neighbors = new int[MAX_NEIGHBOR][2];
                neighbors[0][0] = pos[0] - 1;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] - ROW;
                neighbors[1][1] = pos[1];
                neighbors[2][0] = pos[0];
                neighbors[2][1] = pos[1] + 1;
            } else {
                neighbors = new int[MAX_NEIGHBOR - 1][2];
                neighbors[0][0] = pos[0] - ROW == posPrev[0] ? pos[0] - 1 : pos[0] - ROW;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0];
                neighbors[1][1] = pos[1] + 1;
            }

        } else if (pos[0] == ROW && pos[1] == COLUMN) {
            if (pos[1] - 1 == posPrev[1]) {
                neighbors = new int[MAX_NEIGHBOR - 1][2];
                neighbors[0][0] = pos[0] - 1;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] - ROW;
                neighbors[1][1] = pos[1];
            } else {
                neighbors = new int[MAX_NEIGHBOR - 2][2];
                neighbors[0][0] = pos[0] - ROW == posPrev[0] ? pos[0] - 1 : pos[0] - ROW;
                neighbors[0][1] = pos[1];
            }
        } else if (pos[0] == 0 && pos[1] == COLUMN) {
            if (pos[1] - 1 == posPrev[1]) {
                neighbors = new int[MAX_NEIGHBOR - 1][2];
                neighbors[0][0] = pos[0] + ROW;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] + 1;
                neighbors[1][1] = pos[1];
            } else {
                neighbors = new int[MAX_NEIGHBOR - 2][2];
                neighbors[0][0] = pos[0] + ROW == posPrev[0] ? pos[0] + 1 : pos[0] + ROW;
                neighbors[0][1] = pos[1];
            }
        } else if (pos[0] == ROW) {
            if (pos[1] - 1 == posPrev[1]) {
                neighbors = new int[MAX_NEIGHBOR][2];
                neighbors[0][0] = pos[0] - 1;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] - ROW;
                neighbors[1][1] = pos[1];
                neighbors[2][0] = pos[0];
                neighbors[2][1] = pos[1] + 1;
            } else {
                neighbors = new int[MAX_NEIGHBOR - 1][2];
                neighbors[0][0] = pos[0] - 1 == posPrev[0] ? pos[0] - ROW : pos[0] - 1;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0];
                neighbors[1][1] = pos[1] + 1;
            }
        } else if (pos[1] == COLUMN) {
            if (pos[1] - 1 == posPrev[1]) {
                neighbors = new int[MAX_NEIGHBOR - 1][2];
                neighbors[0][0] = pos[0] - 1;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] + 1;
                neighbors[1][1] = pos[1];
            } else {
                neighbors = new int[MAX_NEIGHBOR - 2][2];
                neighbors[0][0] = pos[0] - 1 == posPrev[0] ? pos[0] + 1 : pos[0] - 1;
                neighbors[0][1] = pos[1];
            }
        } else if (pos[0] == 0) {
            if (pos[1] - 1 == posPrev[1]) {
                neighbors = new int[MAX_NEIGHBOR][2];
                neighbors[0][0] = pos[0] + ROW;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] + 1;
                neighbors[1][1] = pos[1];
                neighbors[2][0] = pos[0];
                neighbors[2][1] = pos[1] + 1;
            } else {
                neighbors = new int[MAX_NEIGHBOR - 1][2];
                neighbors[0][0] = pos[0] + ROW == posPrev[0] ? pos[0] + 1 : pos[0] + ROW;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0];
                neighbors[1][1] = pos[1] + 1;
            }
        } else {
            if (pos[1] - 1 == posPrev[1]) {
                neighbors = new int[MAX_NEIGHBOR][2];
                neighbors[0][0] = pos[0] - 1;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] + 1;
                neighbors[1][1] = pos[1];
                neighbors[2][0] = pos[0];
                neighbors[2][1] = pos[1] + 1;
            } else {
                neighbors = new int[MAX_NEIGHBOR - 1][2];
                neighbors[0][0] = pos[0] - 1 == posPrev[0] ? pos[0] + 1 : pos[0] - 1;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0];
                neighbors[1][1] = pos[1] + 1;
            }
        }
        return filterNeighborsIfItPassed(neighbors, posPassed);
    }

    private static int[][] filterNeighborsIfItPassed(int[][] neighbors, HashMap<Integer, Integer> posPassed) {
        int[] posDup = new int[2];
        boolean flagDup = false;
        if(posPassed.size() >= ROW - 1){

            for (int i = 0; i < neighbors.length; i++) {
                for (Map.Entry<Integer, Integer> entry : posPassed.entrySet()) {
                    if(neighbors[i][0] == entry.getKey() && neighbors[i][1] == entry.getValue()){
                        posDup[0] = entry.getKey();
                        posDup[1] = entry.getValue();
                        flagDup = true;
                    }
                }
            }
            if(flagDup) {
                return removePositionDuplicated(neighbors, posDup);
            }
        }
        return neighbors;
    }

    private static int[] findPosNumberLargestByColumn(int[][] array, int byColumn) {
        int max = array[0][byColumn];
        int pos = 0;
        for (int i = 1; i <= ROW; i++) {
            if (max < array[i][byColumn]) {
                max = array[i][byColumn];
                pos = i;
            }
        }
        return new int[]{pos, byColumn};
    }

}
