package week02.실패율;

import java.util.*;

public class FailRate2 {
    public static int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        int[] passMember = new int[N+1];
        Map<Integer, Double> failRate = new HashMap<>();
        int total = stages.length;

        for (int stage : stages) {
            if (stage <= N) {
                passMember[stage - 1] += 1;
            }
        }

        for(int i = 0; i < N;i++){
            if(total == 0){
                failRate.put(i,0.0);
            }else{
                double fail = (double) passMember[i] / total;
                failRate.put(i+1, fail);
                total-=passMember[i];
            }
        }

       return failRate.entrySet().stream().sorted((o1, o2)-> Double.compare(
               o2.getValue(), o1.getValue()
       )).mapToInt(Map.Entry::getKey).toArray();
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = solution(N, stages);
        System.out.println(Arrays.toString(result));
    }
}


