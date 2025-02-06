package week01.배열뒤집기;

import java.util.Arrays;

public class ReverseSort {
    public static int[] solution(int[] num_list) {
        if (num_list == null) {
            return new int[0];  // 빈 배열 반환
        }

        int[] answer = new int[num_list.length];
        for(int i = 0; i < num_list.length; i++){
            answer[i] = num_list[num_list.length - 1 - i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] num_list = {1, 0, 1, 1, 1, 3, 5};
        int[] result = solution(num_list);
        System.out.println(Arrays.toString(result));



    }
}
