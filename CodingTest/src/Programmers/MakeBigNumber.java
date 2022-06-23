package Programmers;

public class MakeBigNumber {
	public static void main(String[] args) {
		System.out.println(solution("5214683", 3));
	}
	
	public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        char max;
        for(int i = 0; i < number.length() - k; i++) {
            max = '0';

            for(int j = idx; j <= k + i; j++) {
                    if(max < number.charAt(j)) {
                        max = number.charAt(j);  // 최댓값 찾기
                        idx = j + 1;
                    }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
