package Programmers;

import java.util.HashSet;

public class FindPrimeNumber {
	static int totalCnt;
	static String cards[];
	static boolean visit[];
	static int N;
	static HashSet<Integer> numbersSet = new HashSet<>();
	public static void main(String[] args) {
		String numbers = "17";
		System.out.println(solution(numbers));
	}
	
	public static int solution(String numbers) {
        int answer = 0;
        
        for(int i=0; i<numbers.length(); i++) {
        	cards = new String[i+1];
        	N = i+1;
        	visit = new boolean[numbers.length()];
        	dfs("", numbers); // 1개, 2개 순열
        }
        
        return numbersSet.size();
    }

	private static void dfs(String comb, String others) {
		if (!comb.equals("") && isPrime(Integer.parseInt(comb)))
            numbersSet.add(Integer.valueOf(comb));

        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++)
        	dfs(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
	}

	private static boolean isPrime(int num) {
		// 1. 0과 1은 소수가 아니다
        if (num == 0 || num == 1)
            return false;

        // 2. 에라토스테네스의 체의 limit 숫자를 계산한다.
        int lim = (int)Math.sqrt(num);

        // 3. 에라토스테네스의 체에 따라 lim까지 배수 여부를 확인한다.
        for (int i = 2; i <= lim; i++)
            if (num % i == 0)
                return false;

        return true;
	}

}
