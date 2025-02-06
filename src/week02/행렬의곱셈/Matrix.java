package week02.행렬의곱셈;

import java.util.Arrays;

public class Matrix {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;
        int com = arr1[0].length;
        int[][]answer = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                for(int k = 0; k < com; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,4},{3,2},{4,1}};
        int[][] arr2 = {{3,3},{3,3}};
        int[][] result = solution(arr1, arr2);
        System.out.println(Arrays.deepToString(result));
    }
}
