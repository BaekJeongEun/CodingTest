package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BaekJoon10815 { // 숫자카드 (S5)

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arrN = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] arrM = new int[M];
		int[] result = new int[M];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arrM[i] = tmp;
			map.put(tmp, i);
		}
		Arrays.sort(arrN);
		for(int i=0; i<M; i++) {
			int target = arrM[i];
			int start = 0, end = N-1;
			while(start<=end) {
				int mid = (start+end)/2;
				if(arrN[mid] < target) start = mid+1;
				else if(arrN[mid] > target) end = mid-1;
				else {
					result[map.get(target)] = 1;
					break;
				}
			}
		}
		for(int i=0; i<M; i++) System.out.print(result[i]+" ");
	}

}
