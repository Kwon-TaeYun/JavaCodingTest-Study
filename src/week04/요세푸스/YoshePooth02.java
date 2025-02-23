package week04.요세푸스;

import java.util.ArrayDeque;
import java.util.Queue;

public class YoshePooth02 {
    public static int solution (int n, int k){
        int count = 1;
        int size = n; //큐 안에 있어야 할 data 갯수
        ArrayDeque<Integer> circle = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            circle.addLast(i + 1);
        }  // 1,2,3,4,5

        while (circle.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                int pollNum = circle.poll();
                circle.add(pollNum);
            }
            circle.poll();
        }

        Integer last = circle.poll();

        return last;
    }
    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        int output = solution(n,k);
        System.out.println("================");
        System.out.println(output);
    }
}
