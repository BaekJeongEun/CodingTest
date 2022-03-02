package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class BaekJoon1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String st = br.readLine();
		int alphabet[] = new int[26];
		int max = 0;
		
		for(int i=0; i<st.length(); i++) {
			int n = st.charAt(i);
			if(n < 91) {
				alphabet[n-65]++;
			}
			else {
				alphabet[n-97]++;
			}
		}
		for(int i=0; i<26; i++) {
			if(alphabet[i] >= alphabet[max]) {
				max = i;
			}
		}
		for(int i=0; i< 26; i++) {
			if(i!=max && alphabet[max]==alphabet[i]) {
				bw.write('?');
				bw.close();
				return;
			}
		}
		char ch = (char) (max + 65);
		bw.write(ch);
		bw.flush();
		bw.close();
	}

}
