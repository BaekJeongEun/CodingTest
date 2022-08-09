package BaekJoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
public class BaekJoon14232 { // 보석 도둑 (G5)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Long k = Long.parseLong(br.readLine());
		List<Long> list = new LinkedList<>();
		Long cnt = (long) 0;
		// k의 소인수분해
		for(Long i=(long) 2; i<=Math.sqrt(k); i++) {
			while(k%i ==0) {
				k /= i;
				cnt++;
				list.add(i);
			}
		}
		if(k != 1) {
			list.add(k);
			cnt++;
		}
		sb.append(cnt).append("\n");
		for(Long i : list) {
			sb.append(i).append(" ");
		}
		
		bw.write(sb.toString()+"");
		bw.flush();
		bw.close();
	}

}
