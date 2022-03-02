package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon11719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String a="";
		/*
		while((a=br.readLine()) != null) {
			System.out.println(a);
		}
		*/
		while((a=br.readLine()) != null) {
			bw.write(a);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
