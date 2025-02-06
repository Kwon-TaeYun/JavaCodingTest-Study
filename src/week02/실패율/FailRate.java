package week02.실패율;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FailRate {
    public static int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        int[] passMember = new int[N+1];
        List<double[]> failRate = new ArrayList<>();
        int total = stages.length;

        for (int stage : stages) {
            if (stage <= N) {
                passMember[stage - 1] += 1;
            }
        }

        for(int i = 0; i < N;i++){
            if(total == 0){
                failRate.add(new double[]{i + 1, 0});
            }else{
                double fail = (double) passMember[i] / total;
                failRate.add(new double[]{i+1, fail});
                total-=passMember[i];
            }
        }

        failRate.sort((a,b)->{
            if(Double.compare(a[1], b[1]) == 0){
                return Double.compare(a[0],b[0]);
            }else{
                return Double.compare(b[1],a[1]);
            }
        });

        for(int i = 0; i < answer.length; i++){
            answer[i] = (int)failRate.get(i)[0];
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = solution(N, stages);
        System.out.println(Arrays.toString(result));
    }
}
