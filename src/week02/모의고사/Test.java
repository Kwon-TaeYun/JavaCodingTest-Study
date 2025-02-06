package week02.모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] scores = new int[3];
        int[] personA = {1,2,3,4,5};
        int[] personB = {2,1,2,3,2,4,2,5};
        int[] personC = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i = 0; i < answers.length; i++){
            if(personA[i % personA.length] == answers[i]){
                scores[0]++;
            }

            if(personB[i % personB.length] == answers[i]){
                scores[1]++;
            }

            if(personC[i % personC.length] == answers[i]){
                scores[2]++;
            }
        }

        int maxScore = Math.max(Math.max(scores[0], scores[1]), scores[2]);
        for(int i = 0; i < scores.length; i++){
            if(scores[i] == maxScore){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);


        return answer;
    }

    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        int[] result = solution(answers);
        System.out.println(Arrays.toString(result));
    }
}
