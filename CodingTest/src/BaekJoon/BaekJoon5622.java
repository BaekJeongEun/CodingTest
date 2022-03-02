package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon5622 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int arr[] = {2,3,4,5,6,7,8,9,10};
		int sum=0;
		String str[] = {"ABC","DEF", "GHI","JKL","MNO","PQRS","TUV","WXYZ"};
		String st[] = br.readLine().split("");

		for(int l=0; l<st.length; l++) {
			for(int i=0; i<str.length; i++) {
				if(str[i].contains(st[l])){
					sum+=arr[i+1];
				}
			}			
		}
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}

}
