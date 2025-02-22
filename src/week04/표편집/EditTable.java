package week04.표편집;

import java.util.Arrays;
import java.util.Stack;

public class EditTable {
    public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        String[] table = new String[n];
        for (int i = 0; i < n; i++) table[i] = "O";
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < cmd.length; i++){
            String[] parts = cmd[i].split(" ");
            String dir = parts[0];
            //System.out.println(k);
            if(dir.equals("D")){
                int x =  Integer.parseInt(parts[1]);
                while(x > 0 && k < n - 1) {
                    k++;
                    if(!table[k].equals("X")){
                        x--;
                    }
                }
            }else if(dir.equals("U")){
                int x =  Integer.parseInt(parts[1]);
                while(x > 0 && k > 0) {
                    k--;
                    if(!table[k].equals("X")){
                        x--;
                    }
                }
            }
            else if(dir.equals("C")){
                stack.push(k);
                table[k] = "X";
                if(k == n-1){
                    while(table[k].equals("X") && k >= 0){
                        k = k - 1;
                    }

                } else{
                    while(table[k].equals("X") && k < n - 1){
                        k = k + 1;
                    }
                }
//                boolean moved = false;
//                for (int i1 = k + 1; i1 < n; i1++) { // 아래쪽 먼저 확인
//                    if (!table[i1].equals("X")) { // 살아있는 행 발견하면 이동
//                        k = i1;
//                        moved = true;
//                        break;
//                    }
//                }
//                if (!moved) { // 아래쪽이 없으면 위쪽 확인
//                    for (int i2 = k - 1; i2 >= 0; i2--) {
//                        if (!table[i2].equals("X")) {
//                            k = i2;
//                            break;
//                        }
//                    }
//                }

            }
            else if(dir.equals("Z")){
                if(!stack.isEmpty()) {
                    Integer saved = stack.pop();
                    table[saved] = "O";
                }
            }
            //System.out.println(Arrays.toString(table));
        }
        //System.out.println(Arrays.toString(table));
        for(int i = 0; i < table.length; i++){
            answer += table[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        String output = solution(n, k, cmd);
        System.out.println(output);
    }
}
