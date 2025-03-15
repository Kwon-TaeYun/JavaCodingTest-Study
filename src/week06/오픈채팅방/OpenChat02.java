package week06.오픈채팅방;

import java.util.*;

public class OpenChat02 {
    public static String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Queue<String[]> recordList = new LinkedList<>();
        List<String> status = new ArrayList<>(); //Enter, Leave, Change
        for(int i=0;i<record.length;i++){
            recordList.add(record[i].split(" "));
        }
        Queue<String[]> tempQueue = new LinkedList<>(recordList);
        //recordList 에서 꺼내지 않고 임의의 큐에서 recordList 요소들을 다 넣고 다 뺄 생각!
        HashMap<String, String> idName = new HashMap<>(); //<id, name>

       while(!tempQueue.isEmpty()){
           status.add(tempQueue.poll()[0]);
       }
//       System.out.println(status);

        for (String[] entry : recordList) {
            if (!entry[0].equals("Leave")) { // Enter 또는 Change일 때만 닉네임 업데이트
                idName.put(entry[1], entry[2]); // 아이디 → 닉네임 매핑
            }
        }
//        System.out.println(idName); // 최종 닉네임 정보 출력

        for(int i=0;i<record.length;i++){
            String userId = record[i].split(" ")[1];
            if(status.get(i).equals("Enter")){
                answer.add(idName.get(userId)+"님이 들어왔습니다.");
            }else if(status.get(i).equals("Leave")){
                answer.add(idName.get(userId)+"님이 나갔습니다.");
            }else{
                continue;
            }//change일때는 건너뛰기
        }

        return answer.toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234","Enter uid1234 Prodo",
                "Change uid4567 Ryan"};

        String[] output = solution(record);
        System.out.println(Arrays.toString(output));

    }
}
