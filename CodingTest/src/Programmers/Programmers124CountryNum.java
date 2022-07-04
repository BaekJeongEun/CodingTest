package Programmers;

public class Programmers124CountryNum { // 124 나라

	public static void main(String[] args) {
		System.out.println(solution(4));

	}
	public static String solution(int n) {
        String answer = "";
        
        while(n>0) {
        	if(n%3==0) {
        		answer = "4"+answer;
        		n--;
        	}else if(n%3==1) {
        		answer = "1"+answer;
        	}else {
        		answer = "2"+answer;
        	}
        	n /= 3;
        }
        return answer;
    }

}
