package Programmers;

public class 음양더하기 {
	public static void main(String[] args) {

		int[] absolutes= {1,2,3};
		boolean[] signs= {true,false,true};
		int sum=0;
		for(int i=0; i<absolutes.length; i++) {
			if(signs[i]==true)
				sum += absolutes[i];
			else
				sum -= absolutes[i];
		}
		System.out.println(sum);
	}
}
