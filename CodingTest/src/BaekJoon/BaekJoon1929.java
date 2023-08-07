package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1929 { // 소수 구하기(S1)

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean arr[] = new boolean[N + 1];
		arr[0] = arr[1] = true;

		for (int i = 2; i <= Math.sqrt(arr.length); i++) {
			if (arr[i])
				continue;
			for (int j = i * i; j < arr.length; j += i) {
				arr[j] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (!arr[i])
				sb.append(i).append('\n');
		}
		System.out.println(sb);
	}

}

/*
 * package BaekJoon;
 * 
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.io.InputStreamReader; import java.util.StringTokenizer;
 * 
 * public class BaekJoon1929 {
 * 
 * public static void main(String[] args) throws IOException {
 * 
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * String str = br.readLine(); StringTokenizer st = new StringTokenizer(str);
 * int cnt=0; int j; int M = Integer.parseInt(st.nextToken()); int N =
 * Integer.parseInt(st.nextToken());
 * 
 * for(int i=M; i<=N; i++) { cnt=0; for(j=1; j<=i; j++) { if(i%j == 0) { //
 * ������ �������� ��� cnt++; } if(cnt > 2) break; } if(cnt == 2) {
 * System.out.println(i); } } }
 * 
 * }
 */