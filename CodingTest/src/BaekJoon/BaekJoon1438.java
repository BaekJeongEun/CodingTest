package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BaekJoon1438 { // 가장 작은 직사각형
	static int N, min, K, cnt=0;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		K = N / 2;
		arr = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[j][0] > arr[i][0]) {
					maxX = Math.max(maxX, arr[j][0]);
				}
				if(arr[j][1] > arr[i][1]) {
					maxY = Math.max(maxY, arr[j][1]);
				}
			}
		}
		
		for(int i=0; i<=maxX; i++) {
			for(int j=0; j<=maxX; j++) {
				for(int l=0; l<=maxY; l++) {
					for(int k=0; k<=maxY; k++) {
						if(i>j && l>k) {
							for(int m=0; m<N; m++) {
								if(arr[m][0]>j && arr[m][0]<i && arr[m][1]>k && arr[m][1]<l) {
									cnt++;
								}
							}
							if(cnt >= K) {
								int sum = (i-j)*(l-k);
								if(sum < min) {
									min = sum;
								}
							}
							cnt = 0;
						}
					}
				}
			}
		}
		System.out.println(min);
	}
}