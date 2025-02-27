package week05.두개의수로특정값만들기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static boolean solution(int[] arr, int target){
        boolean answer = false;
        Set<Integer> matchSet = new HashSet<>();
//        for(int i = 0; i < arr.length; i++){
//            for(int j = i+1; j < arr.length; j++){
//                if(arr[i] + arr[j] == target){
//                    return true;
//                }
//            }
//        }
//
//        return false;

        for(int i = 0; i < arr.length; i++){
            if(matchSet.contains(target-arr[i])){
                return true;
            }
            matchSet.add(arr[i]);
        }
        return false;


    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,8};
        int target = 6;
        boolean output = solution(arr, target);
        System.out.println(output);

    }
}
