package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[10];
		int sub[] = {1,1,1,1,1,1,2,1,1};
		int cnt=0, num=0;
		String str[] = br.readLine().split("");
		for(int i=0; i<str.length; i++) {
			int index = Integer.parseInt(str[i]);
			if(index==9) index = 6;
			arr[index]++;
		}
		while(true) {
			cnt=0;
			for(int i=0; i<9; i++) {
				
				if(arr[i]>0)
					arr[i] -= sub[i];
				
				else
					cnt++;
			}
			if(cnt>=9) break;
			num++;
		}
		System.out.println(num);
	}

}
