package week04.기능개발;

import java.util.*;

public class DevelopFunction {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++){
            int remain = 100 - progresses[i]; //남은 진행률
            int days = (remain -1 + speeds[i]) / speeds[i]; //진행률 완료위한 남은 일수
            queue.offer(days);
        }

        while(!queue.isEmpty()){
            int first = queue.poll();
            int count = 1;

            while (!queue.isEmpty() && first >= queue.peek()){
                queue.poll();
                count+=1;
            }

            answer.add(count);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] output = solution(progresses, speeds);
        System.out.println(Arrays.toString(output));
    }
}
