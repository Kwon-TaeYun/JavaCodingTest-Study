package week01.배열정렬하기;
import java.util.Arrays;

import static java.util.Arrays.*;

public class ArraySort {
    public static int[] solution(int[] input){
        sort(input);
        return input;
    }
    public static void main(String[] args) {
        int[] input = {1,-5,2,4,3};
        solution(input);
        System.out.println(Arrays.toString(input));
    }
}
