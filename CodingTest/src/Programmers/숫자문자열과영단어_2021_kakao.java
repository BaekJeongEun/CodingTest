package Programmers;

public class 숫자문자열과영단어_2021_kakao {
	public static void main(String[] args){
		String s = "23four5six7";
		int answer = 0;

		String[][] arr = {{"0","zero"}, {"1","one"}, {"2","two"}, {"3","three"}, {"4","four"}, {"5","five"}, {"6","six"}, {"7","seven"}, {"8","eight"}, {"9","nine"}};
		
		for(int i=0; i<arr.length; i++) {
			if(s.contains(arr[i][1])) {
				s = s.replace(arr[i][1], arr[i][0]);
			}
		}
		answer = Integer.parseInt(s);
        System.out.println(answer);
	}
}
