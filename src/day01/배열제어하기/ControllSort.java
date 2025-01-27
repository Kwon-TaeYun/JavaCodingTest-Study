package day01.배열제어하기;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.*;

public class ControllSort {
    public static Integer[] solution(int[] input){
        Integer[] chk = new Integer[input.length];
        int index = 1; //chk의 인덱스

        //1. 일단 오름차순 정렬
        sort(input);

        //2. 정렬된 input의 첫번째 인덱스 chk에 넣기
        chk[0] = input[0];

        //3. chk의 마지막 원소와 input의 원소와 비교하기
        for(int i = 1; i < input.length; i++){
            if(chk[index - 1] != input[i]){
                chk[index] = input[i];
                index++;
            }
        }

        //4. 마지막부터 비교하여 null이 아니면 최종 output에 집어넣어주기
        Integer[] output = new Integer[index];
        int outdex = 0;
        for(int o = input.length-1; o >= 0; o--){
            if(chk[o] != null){
                output[outdex] = chk[o];
                outdex++;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] input = {4,2,2,1,3,4};
        Integer[] output = solution(input);
        System.out.println(Arrays.toString(output));
    }
}


