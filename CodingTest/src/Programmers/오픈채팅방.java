package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 오픈채팅방 {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan", "Change uid1234 Muzom"};
		String[] answer = {};
		int answer_size = 0, index=0;
		
		HashMap<String, String> map = new HashMap<>();
		for(int i=0; i<record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			
			String state = st.nextToken();
			String id = st.nextToken();
			
			if(state.equals("Enter") || state.equals("Change")) {
				String name = st.nextToken();
				System.out.println(name);
				map.put(id, name);
			}	
			if(state.equals("Enter") || state.equals("Leave"))
				answer_size++;
		}
		answer = new String[answer_size];
		for(int i=0; i<record.length; i++) {
			String str="";
			StringTokenizer st = new StringTokenizer(record[i]);
			String state = st.nextToken();
			String id = st.nextToken();
			String name="";
			if(state.equals("Enter")){
				name = st.nextToken();
				str += map.get(id)+"님이 들어왔습니다.";
				answer[index++] = str;
			}
			else if(state.equals("Leave")){
				str += map.get(id)+"님이 나갔습니다.";
				answer[index++] = str;
			}else if(state.equals("Change")) {
				name = st.nextToken();
			}
		}
		System.out.println(Arrays.toString(answer));
		
	}
}
