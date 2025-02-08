package week02.올바른괄호;

import java.lang.reflect.Array;
import java.util.Stack;

public class CorrectBracket {
    static boolean solution(String s) {
        boolean answer = true;
        String[] arr = s.split("");; // 스트링을 한글자씩 담을 배열
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("(")) {
                stack.push(arr[i]);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }


        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "(()(";
        boolean output = solution(input);
        System.out.println(output);
    }
}
