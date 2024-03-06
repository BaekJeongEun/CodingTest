package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon16198 { // 에너지 모으기(S1)
	static int N, max = Integer.MIN_VALUE;
	static ArrayList<Integer> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());	
		arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		pick(0);
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
	private static void pick(int sum) {
		if (arr.size() == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < arr.size() - 1; i++) {
            int tmp = arr.get(i);
            int chargeValue = arr.get(i - 1) * arr.get(i + 1);
            arr.remove(i);
            pick(sum + chargeValue);
            arr.add(i, tmp);
        }
	}
}
