package week04.표편집;

import java.util.Arrays;
import java.util.Stack;

public class EditTable02 {
    public static String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();
        int[] up = new int[n];
        int[] down = new int[n];

        //표의 인덱스 0 ~ n-1
        for (int i = 0; i < n; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }//연결 리스트로 두어, 인덱스 범위를 벗어나는 순간 -1로 둔다.
        //예를 들어 up[0] = -1, down[n-1] = -1

        down[n-1] = -1;

        for (String s : cmd) {
            if (s.startsWith("C")) {
                stack.push(k);
                if(down[k] != -1) {
                    up[down[k]] = up[k];
                }
                if(up[k] != -1) {
                    down[up[k]] = down[k];
                }
                k = down[k] == -1 ? up[k] : down[k];
            } else if (s.startsWith("Z")) {
                int discovered = stack.pop();
                if(up[discovered] != -1) {
                    down[up[discovered]] = discovered;
                }
                if(down[discovered] != -1) {
                    up[down[discovered]] = discovered;
                }
            } else {
                String[] c = s.split(" ");
                int dir = Integer.parseInt(c[1]);
                for (int i = 0; i < dir; i++) {
                    k = c[0].equals("U") ? up[k] : down[k];
                }
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        while (!stack.isEmpty()) {
            int popped = stack.pop();
            answer[popped] = 'X';
        }
        return new String(answer);
    }
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        String output = solution(n, k, cmd);
        System.out.println(output);
    }
}
