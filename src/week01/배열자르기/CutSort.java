package week01.배열자르기;

import java.util.Arrays;

public class CutSort {
    public static int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] result = new int[size];

        for(int i = 0; i < size; i++){
            long index = left + i;
            int row = (int)(index / n);
            int col = (int)(index % n);
            result[i] = Math.max(row+1, col+1);

        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3,2,5)));
        System.out.println(Arrays.toString(solution(4,7,14)));
    }
}
