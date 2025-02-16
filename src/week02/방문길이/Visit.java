package week02.방문길이;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Visit {
    private static boolean isValid(int x, int y){
        return x >= 0 && x < 11 && y >= 0 && y < 11;
    }

    public static int solution(String dirs) {
        int answer = 0;
        int x = 5;
        int y = 5;
        int[][] loc = new int[11][11]; //좌표
        Map<Character, int[]> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        map.put('U', new int[]{1,0});
        map.put('D', new int[]{-1,0});
        map.put('R', new int[]{0,1});
        map.put('L', new int[]{0,-1});


        for(int i = 0; i < dirs.length(); i++){
            int[] offset = map.get(dirs.charAt(i));
            if(!isValid(x + offset[0], y + offset[1])){
                continue;
            }else{
                int nx = x + offset[0];
                int ny = y + offset[1];
                String path1 = "(" + x + "," + y + ")" + "(" + nx + "," + ny + ")";
                String path2 = "(" + nx + "," + ny + ")"+"(" + x + "," + y + ")";

                if(!set.contains(path1) && !set.contains(path2)){
                    set.add(path1);
                    set.add(path2);
                    answer += 1;
                }

                x = nx;
                y = ny;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        String input = "LULLLLLLU";
        int output = solution(input);
        System.out.println(output);
    }

}

