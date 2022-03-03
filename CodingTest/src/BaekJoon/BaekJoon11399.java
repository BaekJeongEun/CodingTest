package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon11399 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), sum=0, result=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for(int i=0; st.hasMoreTokens(); i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 값 입력
		}
		Arrays.sort(arr); // 오름차순 정렬
		for(int i=0; i<N; i++) {
			sum = sum + arr[i];	// 현재 사람이 기다린 시간
			result += sum;		// 누적 시간
		}
		System.out.println(result); // 누적 시간 출력
	}

}
