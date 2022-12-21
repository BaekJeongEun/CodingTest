package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class BaekJoon1076 { // 저항 (B2)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, String[]> map = new HashMap<>();
		map.put("black", new String[] {"0", "1"});
		map.put("brown", new String[] {"1", "10"});
		map.put("red", new String[] {"2", "100"});
		map.put("orange", new String[] {"3", "1000"});
		map.put("yellow", new String[] {"4", "10000"});
		map.put("green", new String[] {"5", "100000"});
		map.put("blue", new String[] {"6", "1000000"});
		map.put("violet", new String[] {"7", "10000000"});
		map.put("grey", new String[] {"8", "100000000"});
		map.put("white", new String[] {"9", "1000000000"});
		StringBuilder sb = new StringBuilder();
		sb.append(map.get(br.readLine())[0]).append(map.get(br.readLine())[0]).append(map.get(br.readLine())[1].substring(1));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
