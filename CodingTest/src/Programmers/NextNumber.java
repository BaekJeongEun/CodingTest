package Programmers;

public class NextNumber { // 다음 큰 숫자(L2)

	public static void main(String[] args) {
		System.out.println(solution(78));
	}
	
	static public int solution(int n) {
        int answer = n+1;

        int nBit = Integer.bitCount(n);


        while (true) {
            int ansBit = Integer.bitCount(answer);

            if (ansBit == nBit) {
                return answer;
            } else {
                answer++;
            }
        }

    }
}
