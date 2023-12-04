package Programmers;

public class JumpingAndTeleportation { // 점프와 순간 이동(L2)

	public static void main(String[] args) {
		System.out.println(solution(5));
	}

	public static int solution(int n) {
		int ans = 0;
		while (n != 1) {
			if (n % 2 == 0)
				n /= 2;
			else {
				n -= 1;
				ans++;
			}
		}
		ans++;
		return ans;
	}
}
