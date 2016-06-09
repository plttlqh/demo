package com.example;

public class Main {
    public static final int n=3;
    public static final int m=3;
    public static final int MAX_NEIGHBOR = 3;

    public static void main(String[] args) {

        int[][] array = new int[][]{
                {-1,4,5,1},
                {2,-1,2,4},
                {3,3,-1,3},
                {4,2,1,2}
        };
        int[] pos;
        int[] posNext;
        int[] posPrev = new int[1];
//        int[] sumAllPath = new int[n*m];
        int sum = 0;
        pos = findPosNumberLargestByColumn(array, 0);
        int count = 0;
        posPrev = pos;
        do {
            int[][] posNumberNeighbor = findPosNumberNeighbor(pos, posPrev);
            posNext = findPosNumberLargestByNeighbor(posNumberNeighbor, array);
            sum+= array[pos[0]][pos[1]];
            posPrev = pos;
//            if(array[posNext[0]][posNext[1]] > sum){
//                System.out.println("sout");
//            }
            pos = posNext;

        } while (array[posNext[0]][posNext[1]] != -1 && pos[1] <=m);

    }

    private static int[] findPosNumberLargestByNeighbor(int[][] posNumberNeighbor, int[][] array) {
        int max = -1;
        int posX = posNumberNeighbor[0][0], posY = posNumberNeighbor[0][1];
        for (int i = 0; i < posNumberNeighbor.length; i++) {
            if(array[posNumberNeighbor[i][0]][posNumberNeighbor[i][1]] == -1){
                continue;
            }
            if(max < array[posNumberNeighbor[i][0]][posNumberNeighbor[i][1]]){
                max = array[posNumberNeighbor[i][0]][posNumberNeighbor[i][1]];
                posX = posNumberNeighbor[i][0];
                posY = posNumberNeighbor[i][1];
            }
        }
        return new int[]{posX, posY};
    }

    private static int[][] findPosNumberNeighbor(int[] pos, int[] posPrev) {
        int[][] neighbors;
        if( pos[0] == 0 && pos[1] == 0){
            neighbors = new int[MAX_NEIGHBOR - 1][2];
            neighbors[0][0] = pos[0] + 1 == posPrev[0] ? pos[0] + n : pos[0] + 1;
            neighbors[0][1] = pos[1];
            neighbors[1][0] = pos[0];
            neighbors[1][1] = pos[1]+1;
        } else if(pos[0] == n && pos[1] == 0){
            neighbors = new int[MAX_NEIGHBOR][2];
            neighbors[0][0] = pos[0] - 1;
            neighbors[0][1] = pos[1];
            neighbors[1][0] = pos[0] - n;
            neighbors[1][1] = pos[1];
            neighbors[2][0] = pos[0];
            neighbors[2][1] = pos[1]+1;
        } else if (pos[0] == n){
            if(pos[1] - 1 == posPrev[1]){
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
        } else if(pos[0] == n && pos[1] == m || pos[1] == m){
            if(pos[1] - 1 == posPrev[1]){
                neighbors = new int[MAX_NEIGHBOR - 1][2];
                neighbors[0][0] = pos[0] - 1 == posPrev[0] ? pos[0] - n : pos[0] + 1;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] - n == posPrev[0] ? pos[0] - 1 : pos[0] - n;
                neighbors[1][1] = pos[1];
            } else {
                neighbors = new int[MAX_NEIGHBOR - 2][2];
                neighbors[0][0] = pos[0] - n == posPrev[0] ? pos[0] - 1 : pos[0] - n;
                neighbors[0][1] = pos[1];
            }
        } else if(pos[0] == 0){
            if(pos[1] - 1 == posPrev[1]){
                neighbors = new int[MAX_NEIGHBOR][2];
                neighbors[0][0] = pos[0] - 1 == posPrev[0] ? pos[0] - n : pos[0] + 1;
                neighbors[0][1] = pos[1];
                neighbors[1][0] = pos[0] - n == posPrev[0] ? pos[0] - 1 : pos[0] - n;
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
        }else {
            if(pos[1] - 1 == posPrev[1]){
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
            if(max < array[i][byColumn]){
                max = array[i][byColumn];
                pos = i;
            }
        }
        return new int[]{pos, byColumn};
    }

}
