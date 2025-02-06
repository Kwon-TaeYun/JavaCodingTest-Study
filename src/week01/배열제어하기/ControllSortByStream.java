package week01.배열제어하기;

import java.util.Arrays;
import java.util.Collections;

public class ControllSortByStream {
    public static int[] solution( int[] arr){
        Integer [] result = Arrays.stream(arr).boxed().distinct().toArray(Integer []::new);
        Arrays.sort(result, Collections.reverseOrder());
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] input = {4,2,2,1,3,4};
        int[] output = solution(input);
        System.out.println(Arrays.toString(output));
    }
}
