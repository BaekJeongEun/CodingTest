package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BaekJoon2108 {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum=0, avg=1, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE, most=Integer.MIN_VALUE;
		for(int i=0;i <N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			sum += arr[i];
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		// 평균
		avg = (int)Math.round((double)sum/N);
		sb.append(avg+"\n");
		
		// 중앙
		Arrays.sort(arr);
		sb.append(arr[arr.length/2]+"\n");
		
		// 최빈값
		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
		    @Override
		    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
		    	if(o2.getValue() == o1.getValue())
		    		return Math.min(o2.getKey(), o1.getKey());
			return o2.getValue() - o1.getValue();
		    }
		});
		sb.append(map.keySet().iterator().next()+"\n");
		
		// 범위
		sb.append(max-min+"\n");
		
		System.out.println(sb.toString());
	}

}
