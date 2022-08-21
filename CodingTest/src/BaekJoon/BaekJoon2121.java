package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BaekJoon2121 { // 넷이 놀기(S3)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), answer=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		Map<Integer, PriorityQueue<Integer>> map = new TreeMap<Integer, PriorityQueue<Integer>>();
		PriorityQueue<Integer> temp = null;

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			if(!map.containsKey(width)) {
				 map.put(width, new PriorityQueue<>());
			}
			map.get(width).add(height);
		}
		
		for(Integer x : map.keySet()) {
			int cnt=0;
			for(Integer y : map.get(x)) {
				cnt = 0;
				if(map.containsKey(x+A) && map.get(x+A).contains(y+B)) {
					cnt++;
				}else continue;
				if(map.containsKey(x+A) && map.get(x+A).contains(y)) {
					cnt++;
				}else continue;
				if(map.get(x).contains(y+B)) {
					cnt++;
				}else continue;
				if(cnt == 3) answer++;
			}
			
		}
		System.out.println(answer);
	}

}
