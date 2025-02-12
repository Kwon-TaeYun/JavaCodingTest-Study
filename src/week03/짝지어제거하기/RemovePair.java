package week03.짝지어제거하기;

import java.util.ArrayDeque;

public class RemovePair {
    public static int solution(String s)
    {
        int answer = -1;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if(stack.isEmpty()){
                stack.push(c);
            } else {
                if (stack.peek() != c) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        }

        answer = (stack.isEmpty())?1:0;


        return answer;
    }

    public static void main(String[] args) {
        String input = "cdcd";
        int output = solution(input);
        System.out.println(output);
    }
}
