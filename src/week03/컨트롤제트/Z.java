package week03.컨트롤제트;

import java.util.Stack;

public class Z {
    public static int solution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        String[] arr = s.split(" "); //" "로 띄어쓰기 되어있는 부분을 기준으로 배열에 채우기

        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("Z")){
                answer -= Integer.parseInt(String.valueOf(stack.pop()));
            } else{
                answer += Integer.parseInt(String.valueOf(arr[i]));
                stack.push(Integer.valueOf(arr[i]));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String input = "10 Z 20 Z 1";
        int output = solution(input);
        System.out.println(output);
    }
}
