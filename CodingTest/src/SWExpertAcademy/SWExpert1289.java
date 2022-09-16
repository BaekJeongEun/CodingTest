package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWExpert1289 { // 원재의 메모리 복구하기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=N; tc++) {
			int cnt = 0;
			String target = br.readLine();
			char current = '0';
			
			for(int i=0; i<target.length(); i++) {
				if(target.charAt(i) != current) {
					cnt++;
					current = target.charAt(i);
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
		}
	}

}
