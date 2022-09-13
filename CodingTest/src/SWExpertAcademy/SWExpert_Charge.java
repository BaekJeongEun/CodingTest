package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWExpert_Charge {
	static int[] A, B;
	static int time, BC_count, total;
	static int[] visitA, visitB;
	static int[][] dir = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } }; // 상 우 하 좌
	static ArrayList<AP> apList;
	static AP[] combList;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time = Integer.parseInt(st.nextToken());
			BC_count = Integer.parseInt(st.nextToken()); // BC 개수
			apList = new ArrayList<>();
			total = 0;
			A = new int[time+1];
			B = new int[time+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < time; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < time; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < BC_count; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());

				apList.add(new AP(x, y, C, P));
			}
			
			move();

			System.out.println(total);
		}

	}

	private static void move() {
		int AX = 1, AY = 1, BX = 10, BY = 10;
		for (int t = 0; t <= time; t++) {
            int[] A = new int[BC_count];
            int[] B = new int[BC_count];

            for (int i=0; i<apList.size(); i++) { // 거리 비교
                if (Math.abs(AX - apList.get(i).x) + Math.abs(AY - apList.get(i).y) <= apList.get(i).C) 
                	A[i] = apList.get(i).P;
                if (Math.abs(BX - apList.get(i).x) + Math.abs(BY - apList.get(i).y) <= apList.get(i).C) 
                	B[i] = apList.get(i).P;
            }

            int max = Integer.MIN_VALUE;

            for (int i = 0; i <BC_count; i++) {
                for (int j = 0; j < BC_count; j++) {
                    int sum = A[i] + B[j]; // 각각 충전기 용량만큼 더해주기
                    if (i == j && A[i] != 0 && B[j] != 0) // 같은 충전기에 도달할 경우 나눠 가지기
                    	sum /= 2;
                    max = Math.max(max, sum);
                }
            }
            total += max;

            int AMove = A[t], BMove = B[t];
            AX += dir[AMove][0];
            AY += dir[AMove][1];
            BX += dir[BMove][0];
            BY += dir[BMove][1];
		}
	}

	static public class AP {
		int x, y, C, P;

		public AP(int x, int y, int C, int P) {
			this.x = x;
			this.y = y;
			this.C = C;
			this.P = P;
		}
	}

}
