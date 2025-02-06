package week01.나누어떨어지는숫자배열;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class DivisorSort {
    public static int[] solution(int[] arr, int divisor) {
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] % divisor==0){
                count++;
            }
        }

        int[]answer = new int[count];
        int index = 0;
        if(count > 0) {
            for (int num : arr) {
                if (num % divisor == 0) {
                    answer[index] = num;
                    index += 1;
                }
            }
            sort(answer);
            return answer;
        } else{
            return new int[]{-1};
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 9, 7, 10}, 5)));  // [5, 10]
        System.out.println(Arrays.toString(solution(new int[]{2, 36, 1, 3}, 1)));  // [1, 2, 3, 36]
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 6}, 10)));     // [-1]
        System.out.println(Arrays.toString(solution(new int[]{1}, 1)));            // [1]
        System.out.println(Arrays.toString(solution(new int[]{1000000, 999999}, 1)));  // [999999, 1000000]
    }
}
