package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1049 { // 기타줄 (S4)
	static int N, M, min = Integer.MAX_VALUE;
	static int[] oneArr, manyArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		oneArr = new int[M];
		manyArr = new int[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int many = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			manyArr[i] = many;
			oneArr[i] = one;
		}
		Arrays.sort(manyArr);
		Arrays.sort(oneArr);
		
		min = Math.min(((N/6)+1)*manyArr[0], N*oneArr[0]);
		min = Math.min(min, (N/6)*manyArr[0] + (N%6)*oneArr[0]);
		System.out.println(min);
	}
}
