package Programmers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class Printer {
	
	public static void main(String[] args) {
		System.out.println(solution( new int[]{2, 1, 3, 2},2));

	}
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<priorities.length; i++) {
        	map.put(i, priorities[i]);
        	q.add(i);
        }
        while(!q.isEmpty()) {
        	int max=0;
        	int max_idx=0;
        	for(Integer qu : q) {
        		if(max<map.get(qu)) {
        			max = map.get(qu);
        			max_idx = qu;
        		}
        	}
        	int idx=q.peek();
        	while(idx!=max_idx) {
        		q.add(q.poll());
        		idx=q.peek();
        	}
        	int current = q.poll();
        	map.remove(current);
        	if(current==location)
        		break;
        	else
        		answer++;
        }
        return answer+1;
    }
}
