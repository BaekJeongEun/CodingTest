package Programmers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 신고결과받기 {
	public static void main(String[] args) throws IOException{
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		int[] answer = new int[id_list.length];
		
		HashMap<String, 신고> map = new HashMap<>();
		
		for(int i=0; i<id_list.length; i++) {
			map.put(id_list[i], new 신고()); // key:내이름, value:정보들
		}
		
		for(int i=0; i<report.length; i++) {
			StringTokenizer st = new StringTokenizer(report[i]);
			String front = st.nextToken();
			String back = st.nextToken();
			if(!map.get(front).내가신고한사람들.containsKey(back)) { // 내가 신고하는 사람이 없을 경우
				map.get(front).내가신고한사람들.put(back, 1); // 신고 리스트에 추가
				map.get(back).날신고한사람들.put(front, 1);
				map.get(back).신고당한횟수++;
			}
		}
		for(int i=0; i<id_list.length; i++) {
			if(map.get(id_list[i]).신고당한횟수 >= k) {
				// 나 신고 많이 당했으니까 내 이름을 가지고 있는 사람들의 이메일 횟수++
				for(String key : map.get(id_list[i]).날신고한사람들.keySet()) {
					map.get(key).이메일횟수++;
				}
			}
		}
		int index=0;
		for(int i=0; i<id_list.length; i++) {
			answer[i] = map.get(id_list[i]).이메일횟수;
		}
		
	}
	static public class 신고{
		HashMap<String, Integer> 내가신고한사람들 = new HashMap<>();
		HashMap<String, Integer> 날신고한사람들 = new HashMap<>();
		int 신고당한횟수 = 0;
		int 이메일횟수 = 0;
	}
}