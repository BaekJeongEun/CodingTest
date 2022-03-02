package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekJoon2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Tower> towers = new Stack<>();// 레이저 수신 후보탑들 들어가는 스택
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			Tower now = new Tower(i, Integer.parseInt(st.nextToken()));
			// 지금 입장한 탑의 레이저를 누가 수신하나?
			// 후보탑들이 있다면 현재 타워보다 높이 낮은 애들은 다 갖다 버린다
			while(!towers.isEmpty() && towers.peek().height<now.height) {
				towers.pop();
			}
			// 이제 남은 가능성은 두 가지
			if(towers.isEmpty()) { // 스택에 있는 애들이 다 난쟁이라 다 버려졌거나
				sb.append("0 ");
			}else { // 아니면 키 큰 타워 남았겠지
				sb.append(towers.peek().num+" ");
			}
			towers.push(now); // 내 뒤에 들어올 놈들이 나보다 키 작으면 내가 레이저 수신 후보!
		}
		System.out.println(sb.toString());
	}

	static class Tower {
		int num, height;

		Tower(int n, int h) {
			num = n;
			height = h;
		}
	}
}
