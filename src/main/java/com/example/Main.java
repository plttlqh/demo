package com.example;

public class Main {
    public static final int n = 3;
    public static final int m = 3;
    public static final int MAX_NEIGHBOR = 3;

    private static int sumOtherPath = 0;

    public static void main(String[] args){

//        int[][] array = new int[][]{
//                {-1,4,5,1},
//                {2,-1,2,4},
//                {3,3,-1,3},
//                {4,2,1,2}
//        };

        int[][] array = new int[][]{
                {-1,4,5,142},
                {2,-1,2,4},
                {3,3,-1,-1},
                {4,2,1,244}
        };

//        int[][] array = new int[][]{
//                {-1, 4, 5, 1},
//                {2, -1, 2, 4},
//                {3, 3, -1, -1},
//                {4, 2, 1, 2}
//        };
        int[] pos;
        int[] posNext = new int[1];
        int[] posPrev;
        int[] posPrevPrev;
        pos = findPosNumberLargestByColumn(array, 0);
        posPrevPrev = posPrev = pos;
        int sum = 0;
        boolean flagGoUpOrDow = false;
        sum = findHighestScore(array, pos, posPrev, posPrevPrev, posNext, sum, flagGoUpOrDow);
        System.out.println("Highest way: " + sum);
    }

    private static int findHighestScore(int[][] array, int[] pos, int[] posPrev, int[] posPrevPrev, int[] posNext, int sum, boolean flagGoUpOrDow){
        do {
            int[][] posNumberNeighbor = findPosNumberNeighbor(pos, posPrev, posPrevPrev);
            try {
                posNext = findPosNumberLargestByNeighbor(posNumberNeighbor, array);
            } catch (NullPointerException e) {
                System.out.println("Neighbors not found");
                return sum += array[pos[0]][pos[1]];
            }
            flagGoUpOrDow = checkGoUpOrGoDown(pos, posNext);

            if(flagGoUpOrDow){
                sum += array[pos[0]][pos[1]];
                int[] posNextOtherPath = new int[2];
                try {
                    if(posNumberNeighbor.length == 1){
                        sum = sum > array[posNumberNeighbor[0][0]][posNumberNeighbor[0][1]] ? sum : array[posNumberNeighbor[0][0]][posNumberNeighbor[0][1]];
                        return sum > sumOtherPath ? sum : sumOtherPath;
                    } else {
                        posNextOtherPath = findPosNumberNextToLargestByNeighbor(posNumberNeighbor, array, posNext);
                    }
                } catch (NullPointerException e){
                    System.out.println("Neighbors not found by findPosNumberNextToLargestByNeighbor ");
                    return sum;
                }
                if(array[posNextOtherPath[0]][posNextOtherPath[1]] == -1){
                    return sum;
                }
                int[] posPrevPrevNewPath = posPrev;
                int[] posPrevNewPath = pos;
                int[] posNewPath = posNextOtherPath;
                flagGoUpOrDow = checkGoUpOrGoDown(posNewPath, posNextOtherPath);
                int highestScore = findHighestScore(array, posNewPath, posPrevNewPath, posPrevPrevNewPath, posNextOtherPath, sum, flagGoUpOrDow);
                sumOtherPath = sumOtherPath > highestScore ?  sumOtherPath :  highestScore;
                sum = 0;
            } else {
                sum += array[pos[0]][pos[1]];
            }
            posPrevPrev = posPrev;
            posPrev = pos;
            pos = posNext;
        } while (array[posNext[0]][posNext[1]] != -1 && pos[1] <= m);
        return sum > sumOtherPath ? sum : sumOtherPath;
    }

    private static int[] findPosNumberNextToLargestByNeighbor(int[][] posNumberNeighbor, int[][] array, int[] maxOfNeighbor) throws NullPointerException {
        if(posNumberNeighbor.length-1 == 0){
            throw new NullPointerException();
        }
        int[][] cloneNeighbor = new int[posNumberNeighbor.length-1][2];
        for (int i = 0; i < posNumberNeighbor.length; i++) {
            if((posNumberNeighbor[i][0] == maxOfNeighbor[0]) && (posNumberNeighbor[i][1] == maxOfNeighbor[1])) {
                if(i + 1 < posNumberNeighbor.length) {
                    posNumberNeighbor[i][0] = posNumberNeighbor[i + 1][0];
                    posNumberNeighbor[i][1] = posNumberNeighbor[i + 1][1];
                }
            }
        }
        for (int i = 0; i < cloneNeighbor.length; i++) {
            cloneNeighbor[i][0] = posNumberNeighbor[i][0];
            cloneNeighbor[i][1] = posNumberNeighbor[i][1];
        }
        return findPosNumberLargestByNeighbor(cloneNeighbor, array);
    }

    private static boolean checkGoUpOrGoDown(int[] pos, int[] posNext) {
        if (pos[0] - n == posNext[0] || pos[0] + n == posNext[0]) {
            return true;
        }
        return false;
    }

    private static int[] findPosNumberLargestByNeighbor(int[][] posNumberNeighbor, int[][] array) throws NullPointerException {

        int max = array[posNumberNeighbor[0][0]][posNumberNeighbor[0][1]];
        int posX = posNumberNeighbor[0][0], posY = posNumberNeighbor[0][1];
        if(posNumberNeighbor == null){
            throw new NullPointerException();
        }
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

    private static int[][] findPosNumberNeighbor(int[] pos, int[] posPrev, int[] posPrevPrev) {
        int[][] neighbors;
        if (pos[0] == 0 && pos[1] == 0) {
            neighbors = new int[MAX_NEIGHBOR - 1][2];
            neighbors[0][0] = pos[0] + 1 == posPrev[0] ? pos[0] + n : pos[0] + 1;
            neighbors[0][1] = pos[1];
            neighbors[1][0] = pos[0];
            neighbors[1][1] = pos[1] + 1;
        } else if (pos[0] == n && pos[1] == 0) {
            if (pos[0] == posPrev[0] && pos[1] == posPrev[1]) {
                neighbors = new int[MAX_NEIGHBOR][2];
                neighbors[0][0] = pos[0] - 1;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] - n;
                neighbors[1][1] = pos[1];
                neighbors[2][0] = pos[0];
                neighbors[2][1] = pos[1] + 1;
            } else {
                neighbors = new int[MAX_NEIGHBOR - 1][2];
                neighbors[0][0] = pos[0] - n == posPrev[0] ? pos[0] - 1 : pos[0] - n;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0];
                neighbors[1][1] = pos[1] + 1;
            }

        } else if (pos[0] == n && pos[1] == m) {
            if (pos[1] - 1 == posPrev[1]) {
                neighbors = new int[MAX_NEIGHBOR - 1][2];
                neighbors[0][0] = pos[0] - 1;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] - n;
                neighbors[1][1] = pos[1];
            } else {
                neighbors = new int[MAX_NEIGHBOR - 2][2];
                neighbors[0][0] = pos[0] - n == posPrev[0] ? pos[0] - 1 : pos[0] - n;
                neighbors[0][1] = pos[1];
            }
        } else if (pos[0] == 0 && pos[1] == m) {
            if (pos[1] - 1 == posPrev[1]) {
                neighbors = new int[MAX_NEIGHBOR - 1][2];
                neighbors[0][0] = pos[0] + n;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] + 1;
                neighbors[1][1] = pos[1];
            } else {
                if(posPrev[0] - 1 == posPrevPrev[0] || posPrevPrev[0] + 1 == pos[0] + n){
                    neighbors = null;
                } else {
                    neighbors = new int[MAX_NEIGHBOR - 2][2];
                    neighbors[0][0] = pos[0] + n == posPrev[0] ? pos[0] + 1 : pos[0] + n;
                    neighbors[0][1] = pos[1];
                }
            }
        } else if (pos[0] == n) {
            if (pos[1] - 1 == posPrev[1]) {
                neighbors = new int[MAX_NEIGHBOR][2];
                neighbors[0][0] = pos[0] - 1;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] - n;
                neighbors[1][1] = pos[1];
                neighbors[2][0] = pos[0];
                neighbors[2][1] = pos[1] + 1;
            } else {
                neighbors = new int[MAX_NEIGHBOR - 1][2];
                neighbors[0][0] = pos[0] - 1 == posPrev[0] ? pos[0] - n : pos[0] - 1;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0];
                neighbors[1][1] = pos[1] + 1;
            }
        } else if (pos[1] == m) {
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
                neighbors[0][0] = pos[0] + n;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] + 1;
                neighbors[1][1] = pos[1];
                neighbors[2][0] = pos[0];
                neighbors[2][1] = pos[1] + 1;
            } else {
                neighbors = new int[MAX_NEIGHBOR - 1][2];
                neighbors[0][0] = pos[0] + n == posPrev[0] ? pos[0] + 1 : pos[0] + n;
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
        return neighbors;
    }

    private static int[] findPosNumberLargestByColumn(int[][] array, int byColumn) {
        int max = array[0][byColumn];
        int pos = 0;
        for (int i = 1; i <= n; i++) {
            if (max < array[i][byColumn]) {
                max = array[i][byColumn];
                pos = i;
            }
        }
        return new int[]{pos, byColumn};
    }

}
