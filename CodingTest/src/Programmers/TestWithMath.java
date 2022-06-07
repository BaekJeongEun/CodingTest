package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestWithMath {
	static int[][] arr = {{1,2,3,4,5},{2,1,2,3,2,4,2,5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		System.out.println(Arrays.toString(solution(answers)));

	}
	public static int[] solution(int[] answers) {
       
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int max=0;
        for(int tc = 0; tc<3; tc++) {
        	int cnt=0;
        	
        	// 한 사람씩 문제와 비교
        	for(int i=0; i<answers.length; i++) { // 문제 길이만큼 반복
        		if(answers[i]==arr[tc][i%(arr[tc].length)])
        			cnt++;
        	}
        	if(max<=cnt) { // 한 문제라도 맞췄는지
        		if(max==cnt) {
        			map.put(tc+1, cnt);
        		}
        		else {
        			max = cnt;
        			map.clear();
        			map.put(tc+1, cnt);
        		}
        	}
        }
        int idx=0;
        int[] answer = new int[map.size()];
        for(Integer i : map.keySet()) {
        	answer[idx++]=i;
        }
         
        return answer;
    }

}
