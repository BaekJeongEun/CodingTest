package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BaekJoon10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int alphabet[] = new int[26];
		String input = br.readLine();
		String str[] = input.split("");
		
		Arrays.fill(alphabet, -1);
		for(int i=0; i<str.length; i++) {
			if(alphabet[(int)str[i].toCharArray()[0]-97] == -1)
				alphabet[(int)str[i].toCharArray()[0]-97] = i;
		}
		
		for(int i=0; i<alphabet.length; i++) {
			bw.write(String.valueOf(alphabet[i]));
			bw.write(" ");
		}
		bw.close();
	}

}
