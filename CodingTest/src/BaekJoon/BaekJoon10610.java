package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BaekJoon10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] num = br.readLine().split("");
		String str = "";
		int temp=0;
		Arrays.sort(num, Collections.reverseOrder());
		
		for(int i=0; i<num.length; i++) {
			str +=num[i];
			temp += Integer.parseInt(num[i]);
		}

		//long temp = Long.parseLong(str);
		if(Integer.parseInt(num[num.length-1])!=0 || temp%3!=0) {
			System.out.println("-1");
		}else
			System.out.println(str);			
	}
}
