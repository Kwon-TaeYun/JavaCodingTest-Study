package week02.괄호회전하기;
import java.util.Stack;

public class RotateBracket {
    public static int solution(String s) {
        int answer = 0;
        String[] arr = s.split("");
        for(int r = 0; r < arr.length; r++) {
            Stack<String> stack = new Stack<>();
            boolean isValid = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("(") || arr[i].equals("{") || arr[i].equals("[")) {
                    stack.push(arr[i]);
                } else {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    } else {
                        if (arr[i].equals(")") && stack.peek().equals("(") ||
                                arr[i].equals("}") && stack.peek().equals("{") ||
                                arr[i].equals("]") && stack.peek().equals("[")) {
                            stack.pop();
                        }
                    }
                }


            }

            if (isValid && stack.isEmpty()) {
                answer++;
            }

            String c = arr[0];
            for(int iarr = 0; iarr < arr.length-1; iarr++){
                arr[iarr] = arr[iarr+1];
            }
            arr[arr.length-1] = c;

            //System.out.println(Arrays.toString(arr));

        }



        return answer;
    }

    public static void main(String[] args) {
        String input = "[](){}";
        int output = solution(input);
        System.out.println(output);
    }
}
