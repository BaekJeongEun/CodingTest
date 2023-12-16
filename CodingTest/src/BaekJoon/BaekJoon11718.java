package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon11718 { // 그대로 출력하기(B5)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		while(true){
		    String str = br.readLine();
		    if (str == null || str.isEmpty()) {
		        break;
		    }
		    builder.append(str).append("\n");
		}
		br.close();
		bw.write(builder.toString());
		bw.flush();
		bw.close();
	}

}
