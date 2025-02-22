package week04.카드뭉치;

import java.util.ArrayDeque;
import java.util.Queue;

public class Card {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> queue = new ArrayDeque<>();
        Queue<String> queue1 = new ArrayDeque<>();
        for(int i = 0; i < cards1.length; i++){
            queue.add(cards1[i]);
        }
        for(int j = 0; j < cards2.length; j++){
            queue1.add(cards2[j]);
        }
        for(int k = 0; k < goal.length; k++){
            if(!queue.isEmpty() && queue.peek().equals(goal[k])){
                queue.poll();
            } else if(!queue1.isEmpty() && queue1.peek().equals(goal[k])){
                queue1.poll();
            } else{
                return "No";
            }
        }

        return "Yes";
    }

    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        String answer = solution(cards1, cards2, goal);
        System.out.println(answer);
    }
}
