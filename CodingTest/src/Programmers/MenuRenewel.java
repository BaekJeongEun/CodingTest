package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MenuRenewel {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4})));

	}
	public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        
        Arrays.sort(orders, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length()-o2.length();
			}
		});
        
        for(int j=0; j<orders.length; j++) {
        	
        	String target=".";
        	for(int i=0; i<course.length; i++) {
        		if(course[i] == orders[j].length()) {
        			target = orders[j];
        			continue;
        		}
        		if(orders[j].contains(target)) {
        			System.out.println("target "+ target+"  orders "+orders[j]);
        			map.put(orders[j], map.getOrDefault(orders[j], 0)+1);
        		}
        	}
        }
        for(String key : map.keySet()) {
        	if(map.get(key)<=1) {
        		map.remove(key);
        	}
        }
        answer = new String[map.size()];
        int i=0;
        for(String key : map.keySet()) {
        	answer[i++] = key;
        }
        return answer;
    }
}
