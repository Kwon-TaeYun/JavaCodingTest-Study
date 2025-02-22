package week04.요세푸스;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class YoshePooth {
    public static int solution (int n, int k){
        int count = 1;
        int size = n; //큐 안에 있어야 할 data 갯수
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            queue.add(i);
        }
        while(size > 1){
            System.out.println(queue);
            System.out.println(count);
            if(count % k == 0){
                queue.poll();
                size--;
            }else{
                queue.add(queue.poll());
            }
            count++;
        }
        return queue.peek();
    }
    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        int output = solution(n,k);
        System.out.println("================");
        System.out.println(output);
    }
}
