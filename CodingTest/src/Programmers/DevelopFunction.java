package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DevelopFunction {
	static Queue<Integer> queue = new LinkedList();
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {20, 99, 93, 30, 55, 10}, new int[] {5, 10, 1, 1, 30, 5})));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
		int[] answer = {};
        for(int i=0; i<progresses.length; i++) {
        	int remain = (100-progresses[i])/speeds[i];
        	remain = (100-progresses[i])%speeds[i]==0? remain : remain + 1; // 채워야 하는 업무량
        	//System.out.println(remain);
        	queue.add(remain);
        }
        int stored_day=0, day=0;
        while(!queue.isEmpty()) {
        	int now = queue.poll(); // 현재 가장 맨 앞, 채워야 하는 업무량
        	int cnt=1;
        	int size = queue.size();
        	for(int i=0; i<size; i++) {
        		if(now >= queue.peek()) {
        			queue.poll();
        			cnt++;
        		}
        		else {
        			break;
        		}
        	}
        	arr.add(cnt);
        }
        
        int size=0;
        answer = new int[arr.size()];
        for(int temp : arr){ answer[size++] = temp;}
        
        return answer;
    }
}
