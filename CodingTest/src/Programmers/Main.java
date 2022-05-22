package Programmers;
/*
 * 작성자 : 백정은
 * 작성 날짜 : 202-05-21
 * 주제 : '스노우 타운 호텔 방 배정' 과제
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	static HashMap<Long, Long> hashRoom =  new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine()); 		// 방 개수 입력 받기
		String[] inputNum = br.readLine().split(" "); 	// 원하는 방 번호를 공백을 기준으로 나누어 입력 받은 후 분할
		long[] room_number = new long[inputNum.length]; // 방 번호 입력받는 배열
		
		for(int i=0; i<inputNum.length; i++) { // 입력 받은 방 개수만큼 반복
			room_number[i] = Integer.parseInt(inputNum[i]);
		}
		System.out.println(Arrays.toString((solution(k, room_number)))); // 배열 출력
	}
	
	public static long[] solution(long k, long[] room_number) {
		
		long[] result = new long[room_number.length]; 	// 방 번호 배정된 최종 배열
		
		for(int i=0; i<room_number.length; i++) {
			result[i] = findEmptyRoom(room_number[i]); 	// 선택한 방이 비어있는지 확인 후 적절한 방 번호 매칭
		}
		
		return result;
	}
	
	public static long findEmptyRoom(long num) {
		if(!hashRoom.containsKey(num)) { // 원하는 방 번호에 배정 가능하다면
			hashRoom.put(num, num+1);	 // 현재 방 번호 key, 다음 방 번호 value
			return num;
		}
		hashRoom.put(num, findEmptyRoom(hashRoom.get(num))+1); // 원하는 방 번호가 이미 배정되어 있을 경우 다음 방 번호로 다시 찾기
		return hashRoom.get(num)-1;
	}
}
