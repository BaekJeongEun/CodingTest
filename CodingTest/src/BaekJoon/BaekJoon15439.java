package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon15439 { // 베라의 패션(B4)

	public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		int count = 0;

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(i==j) continue;
				count++;
			}
		}
        
		System.out.println(count);
	}
}
