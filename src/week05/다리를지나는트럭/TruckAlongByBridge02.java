package week05.다리를지나는트럭;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TruckAlongByBridge02 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 경과 시간
        Queue<Integer> waitTruck = new LinkedList<>(); // 대기 트럭
        Queue<int[]> bridge = new LinkedList<>(); // 다리를 건너는 트럭
        int currentWeight = 0;

        for (int truckWeight : truck_weights) {
            waitTruck.add(truckWeight);
        }

        while ( !bridge.isEmpty()  || !waitTruck.isEmpty()) {
            answer+=1;

            // 1. 시간이 되면 다리에서 트럭을 제거
            if (!bridge.isEmpty() && bridge.peek()[1] == answer) {
                currentWeight -= bridge.poll()[0];
            }

            // 2. 새로운 트럭을 다리에 올릴 수 있는지 확인
            if (!waitTruck.isEmpty() && currentWeight + waitTruck.peek() <= weight && bridge.size() < bridge_length) {
                int truck = waitTruck.poll();
                bridge.add(new int[]{truck, answer + bridge_length});
                currentWeight += truck;
            }


        }
        return answer;

    }

    public static void main(String[] args) {
        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeight = {7,4,5,6};
        int output = solution(bridgeLength, weight, truckWeight);
        System.out.println(output);
    }
}
