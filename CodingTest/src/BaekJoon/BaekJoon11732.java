package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BaekJoon11732 { // 집합 (S5)

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> all = new HashSet<>();
		HashSet<Integer> temp = new HashSet<>();
		for (int i = 1; i <= 20; i++) {
			all.add(i);
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			int num = 0;
			if(!input.equals("all") && !input.equals("empty"))
				num = Integer.parseInt(st.nextToken());
			switch (input) {
			case "add":
				temp.add(num);
				break;
			case "check":
				if(temp.contains(num)) 
					sb.append("1").append("\n");
				else sb.append("0").append("\n");
				break;
			case "remove":
				temp.remove(num);
				break;
			case "toggle":
				if(temp.contains(num))
					temp.remove(num);
				else temp.add(num);
				break;
			case "all":
				temp = all;
				break;
			case "empty":
				temp.clear();
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
