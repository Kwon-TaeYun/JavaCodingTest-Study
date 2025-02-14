package week03.크레인인형뽑기게임;

import java.util.Stack;

public class Game {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            int i = move - 1;
            for(int j = 0; j < board.length; j++){
                if(board[j][i] != 0){
                    int target = board[j][i];
                    board[j][i] = 0;
                    if(stack.isEmpty() || target != stack.peek()){
                        stack.push(target);
                    }else{
                        stack.pop();
                        answer += 2;
                    }
                    break;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };

        int[] moves = {1,5,3,5,1,2,1,4};
        int output = solution(board, moves);
        System.out.println(output);
    }
}
