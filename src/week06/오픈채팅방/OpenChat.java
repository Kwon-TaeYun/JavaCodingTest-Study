package week06.오픈채팅방;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OpenChat {
    public static String[] solution(String[] record) {
        String[] answerArray;
        List<String> answer = new ArrayList<>();
        HashMap<String, String> members = new HashMap<>();
        for(String r : record){
            String[] splitMember = r.split(" ");
            if(splitMember[0].equals("Enter") || splitMember[0].equals("Change")) {
                members.put(splitMember[1], splitMember[2]);
            }
        }
        System.out.println(members);

        for(String r : record){
            String[] splitMember = r.split(" ");
            String id = members.get(splitMember[1]);
            if(splitMember[0].equals("Enter")){
                answer.add(id + "님이 들어왔습니다.");
            }else if(splitMember[0].equals("Leave")){
                answer.add(id + "님이 나갔습니다.");
            }
        }

        return answer.toArray(String[]::new); //stream 사용 -> 새로운 배열에 넣어줌.
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234","Enter uid1234 Prodo",
                "Change uid4567 Ryan"};

        String[] output = solution(record);
        System.out.println(Arrays.toString(output));

    }
}
