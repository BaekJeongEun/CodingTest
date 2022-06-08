package Programmers;

public class Carpet {

	public static void main(String[] args) {
		
		int answer[] = new int[2];
		answer = solution(24,24);
		System.out.println(answer[0]+" "+answer[1]);
	}

	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int mul = yellow;
        int plus = (brown-4)/2;
        
        for(int i=1; i<=plus/2; i++) {
        	int a = i;
        	int b = plus-i;
        	if(a*b==mul) {
        		answer[0]=b+2;
        		answer[1]=a+2;
        	}
        }
        
        return answer;
    }
}
