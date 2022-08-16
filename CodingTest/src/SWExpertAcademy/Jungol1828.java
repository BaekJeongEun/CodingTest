package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Jungol1828 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt=1;
		int arr[][] = new int[N][2];
		StringTokenizer st;

		for (int k = 0; k < N; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[k][0] = Integer.parseInt(st.nextToken());
			arr[k][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});
		
		int pre = arr[0][1];
		for(int i=1; i<N; i++) {
			if(pre<arr[i][0]) {
				pre = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}