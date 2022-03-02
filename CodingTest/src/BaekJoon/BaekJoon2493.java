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
		Stack<Tower> towers = new Stack<>();// ������ ���� �ĺ�ž�� ���� ����
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			Tower now = new Tower(i, Integer.parseInt(st.nextToken()));
			// ���� ������ ž�� �������� ���� �����ϳ�?
			// �ĺ�ž���� �ִٸ� ���� Ÿ������ ���� ���� �ֵ��� �� ���� ������
			while(!towers.isEmpty() && towers.peek().height<now.height) {
				towers.pop();
			}
			// ���� ���� ���ɼ��� �� ����
			if(towers.isEmpty()) { // ���ÿ� �ִ� �ֵ��� �� �����̶� �� �������ų�
				sb.append("0 ");
			}else { // �ƴϸ� Ű ū Ÿ�� ���Ұ���
				sb.append(towers.peek().num+" ");
			}
			towers.push(now); // �� �ڿ� ���� ����� ������ Ű ������ ���� ������ ���� �ĺ�!
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
