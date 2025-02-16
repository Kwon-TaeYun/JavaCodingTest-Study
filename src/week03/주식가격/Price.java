package week03.주식가격;

import java.util.Arrays;
import java.util.Stack;

public class Price {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < answer.length; i++){
            for(int j = i+1; j < answer.length; j++){
                if(prices[i] <= prices[j]){
                    answer[i] += 1;
                }else{
                    answer[i] += 1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 2, 3};
        int[] output = solution(input);
        System.out.println(Arrays.toString(output));
    }
}
