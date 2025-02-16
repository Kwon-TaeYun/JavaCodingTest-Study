package week02.방문길이;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Visit2 {
    public static int solution(String dirs) {
        int answer = 0;
        int[][] loc = new int[11][11];
        int x = 5;
        int y = 5;
        Map<String, int[]> map = new HashMap<>();
        Set<String> path = new HashSet<>();
        map.put("L", new int[]{-1,0});
        map.put("R", new int[]{1,0});
        map.put("U", new int[]{0,1});
        map.put("D", new int[]{0,-1});
        for (String dir : dirs.split("")) {
            int nx = x + map.get(dir)[0];
            int ny = y + map.get(dir)[1];
            if((nx < 0 || nx > 10)||(ny < 0 || ny > 10)){
                continue;
            }

            path.add(x + "," + y + "-" + nx + "," + ny);
            path.add(nx + "," + ny + "-" + x + "," + y);

            x = nx;
            y = ny;

        }
        return path.size() /2;
    }

    public static void main(String[] args) {
        String input = "ULURRDLLU";
        int output = solution(input);
        System.out.println(output);
    }

}
