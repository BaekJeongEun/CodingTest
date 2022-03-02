package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon10430 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		bw.write(String.valueOf((A+B)%C)+"\n");
		bw.write(String.valueOf(((A%C) + (B%C))%C)+"\n");
		bw.write(String.valueOf((A*B)%C)+"\n");
		bw.write(String.valueOf(((A%C)*(B%C))%C)+"\n");
		bw.flush();
		bw.close();
	}

}
