package week05.다리를지나는트럭;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TruckAlongByBridge {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 경과 시간
        Queue<Integer> waitTruck = new LinkedList<>(); // 대기 트럭
        Queue<Integer> bridge = new LinkedList<>(); // 다리를 건너는 트럭
        int currentWeight = 0;
        int total = 0;

        for (int truckWeight : truck_weights) {
            waitTruck.add(truckWeight);
            total += truckWeight;
        }

//        if(total <= weight && truck_weights.length <= bridge_length) {
//            return truck_weights.length + bridge_length;
//        }else {
            while ( !bridge.isEmpty()|| waitTruck.size() != 1) {
//                System.out.println("bridge" + bridge);
//                System.out.println("waitTruck" + waitTruck);
//                System.out.println(answer);
                answer++;

                if (bridge.isEmpty()) {
                    Integer truck = waitTruck.poll();
                    bridge.add(truck);
                    currentWeight += truck;
                } else {
                    if (!waitTruck.isEmpty() && (bridge.size() == bridge_length || currentWeight + waitTruck.peek() > weight)) {
                        currentWeight -= bridge.poll();
                    } else {
                        Integer truck = waitTruck.poll();
                        bridge.add(truck);
                        currentWeight += truck;
                    }

                }

            }
//        }
        return answer + bridge_length;

    }

    public static void main(String[] args) {
        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeight = {7,4,5,6};
        int output = solution(bridgeLength, weight, truckWeight);
        System.out.println(output);
    }
}
