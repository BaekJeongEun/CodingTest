package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWExpertAcademy1228 { // 암호문1 (D3)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		List<String> arr;
		int N, command;
		for (int tc = 1; tc <= 10; tc++) {
			arr = new ArrayList<>();
			N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr.add(st.nextToken());
			}

			command = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < command; i++) {
				st.nextToken();
				int insert = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());

				for (int s = 0; s < size; s++) {
					arr.add(insert, st.nextToken());
					insert++;
				}
			}

			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(arr.get(i)).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
