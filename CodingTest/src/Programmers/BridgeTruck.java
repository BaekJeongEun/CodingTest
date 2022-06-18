package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck {

	public static void main(String[] args) {
		System.out.println(solution(5, 5, new int[] {2, 2, 2, 2, 1, 1, 1, 1, 1}));
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<truck_weights.length; i++) {
        	queue.add(truck_weights[i]);
        }
        while(!queue.isEmpty()){
        	int now = queue.poll();
        	int temp_weight = weight-now; // 남은 무게
        	
        	int size = queue.size();
        	int plus = 0;
        	for(int i=0; i<size; i++) {
        		if(temp_weight - queue.peek() >=0) {
        			temp_weight -= queue.poll();
        			plus++;
        		}
        		else break;
        	}
        	answer += (bridge_length+plus);
        	System.out.println("answer "+answer);
        }
        return answer+1;
    }
}
