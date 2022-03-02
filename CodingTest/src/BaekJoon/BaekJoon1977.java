package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1977 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int num=0, sum=0, min=0, i=0;
		
		while(true) {
			i++;
			num = i*i;
			if(M <= num && num <= N) {
				if(sum==0) {
					min = num;
				}
				sum += num;
			}
			if(num > N)
				break;
		}
		if(sum==0 && min==0)
			System.out.println("-1");
		else
			System.out.println(sum+"\n"+min);
	}

}
