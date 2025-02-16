package week03.주식가격;

import java.util.Arrays;
import java.util.Stack;

public class PriceByStack {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }

            stack.push(i);

            System.out.println(stack);
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 2, 3};
        int[] output = solution(input);
        System.out.println(Arrays.toString(output));
    }
}
