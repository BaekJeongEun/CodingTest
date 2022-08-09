package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1978 { // 소수 찾기 (S5)
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), cnt=0;
		
		arr = new int[1001];
		arr[1] = 1;
		for(int i=2; i<=1000; i++) {
			sosu(i);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			if(arr[Integer.parseInt(st.nextToken())] ==0)
				cnt++;
		}
		System.out.println(cnt);
	}
	static void sosu(int num) {
		int cnt=0;
		for(int i=2; i*i<=num; i++) {
			if(num%i==0)
				cnt++;
		}
		arr[num] = (cnt==0)?0:cnt;
	}

}
