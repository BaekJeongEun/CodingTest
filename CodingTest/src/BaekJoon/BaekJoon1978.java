package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), cnt=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			if(sosu(Integer.parseInt(st.nextToken())))
					cnt++;
		}
		System.out.println(cnt);
	}
	static boolean sosu(int num) {
		int cnt=0;
		for(int i=1; i<=num; i++) {
			if(num%i==0)
				cnt++;
		}
		return (cnt==2)?true:false;
	}

}
