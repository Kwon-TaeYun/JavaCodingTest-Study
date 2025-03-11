package week05.완주하지못한선수;

import java.util.HashMap;
import java.util.Map;

public class RaceStart {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> names = new HashMap<>();
        for (String p : participant) {
            if(!names.containsKey(p)){
                names.put(p, 1);
            }else{
                names.put(p, names.get(p)+1);
            }
            System.out.println(names);
        }
        for (String c : completion) {
            if(names.containsKey(c)){
                names.put(c, names.get(c)-1);
                if(names.get(c) == 0){
                    names.remove(c);
                }
            }
            System.out.println(names);
        }
        for(String key : names.keySet()){
         answer = key;
        }

        return  answer;
    }
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String answer = solution(participant, completion);
        System.out.println(answer);
    }
}
