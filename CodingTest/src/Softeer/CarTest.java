package Softeer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CarTest { // 자동차 테스트 (L3)
	static int n, q, arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=0; i<q; i++) {
			int m = Integer.parseInt(br.readLine());
			sb.append(binarySearch(m)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static int binarySearch(int m) {
		int left=0, right=n-1, mid = 0;
		// m 찾고, 오른쪽 * 왼쪽
		while(left<=right) {
			mid=(left+right)/2;
			if(m == arr[mid]) {
				return (n-mid-1)*(mid);
			} else if(m < arr[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return 0;
	}
}
