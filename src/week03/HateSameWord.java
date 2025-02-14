package week03;

import java.util.Arrays;
import java.util.Stack;

public class HateSameWord {
    public static Stack<Integer> solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i ++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else{
                if(stack.peek() == arr[i]){
                    continue;
                }else{
                    stack.push(arr[i]);
                }
            }
        }

        return stack;
    }
    public static void main(String[] args) {
        int[] input = {1,1,3,3,0,1,1};
        Stack<Integer> output = solution(input);
        System.out.println(output);
    }
}
