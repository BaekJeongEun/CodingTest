package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DevelopFunction {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1,1,1,1,1,1})));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] temp = new int[100]; //작업의 개수는 100개 이하이므로 100으로 선언
        int day = 0; //temp에 적용할 배포일 수
        
        for(int i=0; i<progresses.length; i++){
            while(progresses[i] + (speeds[i] * day) < 100){
                day++;
            }
            temp[day]++;
        }
        
        int count = 0;
        
        for(int n : temp){//temp배열 값을 하나식 n에 적용
            if(n != 0){ //배열 값이 0이 아니라면
                count ++; //count 증가
            }
        }
        
        int[] answer = new int[count]; //답을 리턴하기 위한 배열 answer 선언
       
        count = 0; //count 0 초기화
        for(int n : temp){
            if(n != 0){
                answer[count++] = n; //answer 배열에 temp 값 넣기
            }
        }
        
        return answer;
    }
}
