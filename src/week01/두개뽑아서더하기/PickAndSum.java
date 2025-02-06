package week01.두개뽑아서더하기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PickAndSum {
    public static int[] solution(int[] numbers) {
       Set<Integer> set = new HashSet<>();//중복 없애기 위함.
       for(int i = 0; i < numbers.length; i++){
           for(int j = i+1; j < numbers.length; j++){
               set.add(numbers[i] + numbers[j]);
           }
       }

       int[] result = new int[set.size()];
       int index = 0;
        for (int i : set) {
            result[index] = i;
            index+=1;
        }

        Arrays.sort(result);
        return result;


    }

    public static void main(String[] args) {
        int[] input = {2,1,3,4,1};
        int[] output = solution(input);
        System.out.println(Arrays.toString(output));

    }
}
