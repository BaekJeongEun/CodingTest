package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon1158 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		ArrayList<Integer> arrL = new ArrayList<>();
		int cnt = 0, tmp=0;

		for (int i = 0; i < N; i++) {
			arrL.add(i+1);
		}
		int index=0;
		for(int j=0; j<N; j++) {
			index = index+K-1;
			if(index >= arrL.size()) {
				index = index % arrL.size();
			}
			
			arr[j] = arrL.get(index);
			arrL.remove(index);
			System.out.println(arr[j] + " " +index);
		}
		System.out.print("<");
		for(int i=0; i<arr.length-1; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println(arr[arr.length-1]+">");

	}

}
