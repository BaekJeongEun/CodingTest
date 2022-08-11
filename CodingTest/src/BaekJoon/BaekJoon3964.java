package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaekJoon3964 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int min = Integer.MAX_VALUE;
			// k의 소인수 분해
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i=2; i*i<=k; i++) {
				while(k%i==0) {
					map.put(i, map.getOrDefault(i, 0)+1);
					k/=i;
				}
			}
			if(k!=1) map.put(k, map.getOrDefault(k, 0)+1);
			
			
			for(Integer i : map.keySet()) { // 팩토리얼에 해당 key 개수 몇 개 나오니
				int count = fact(n, +map.get(i).intValue());
				int div = count / +map.get(i).intValue();
				
				min = Math.min(min, div);
			}
			sb.append(min+"").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int fact(int num, int k) {
		int count = 0;
		if(k==1) {
			return -1;
		}
	    for (int i = k; num / i >= 1; i *= k)
	        count += num / i;
	    
			System.out.println(" ============ ");
	    
	    return count;
	}

}
