package week03.진수변환;

import java.util.ArrayDeque;
import java.util.Stack;

public class DecimalToBinary {
    public static String solution(int n)
    {
        String str="";
        Stack<Integer> stack = new Stack<>();

        while(n != 0){
            stack.push(n % 2);
            n = (int)(n / 2);

        }
        while(stack.isEmpty() != true){
            str += stack.pop();

        }

        String answer =  str;


        return answer;
    }
    public static void main(String[] args) {
        int input = 10;
        String output = solution(input);
        System.out.println(output);

    }
}

