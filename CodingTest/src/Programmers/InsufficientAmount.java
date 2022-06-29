package Programmers;

public class InsufficientAmount {

	public static void main(String[] args) {
		System.out.println(solution(3,20,4));
	}
	public static long solution(int price, int money, int count) {
        long answer = money;
        
        for(int i=1; i<=count; i++) {
        	answer -= price*i;
        }
        
        return answer>=0? 0 : Math.abs(answer);
    }
}
