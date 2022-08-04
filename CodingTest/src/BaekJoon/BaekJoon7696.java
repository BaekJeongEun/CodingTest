package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon7696 { // 반복하지 않는 수 (S4)
	static int[] arr = new int[1000001];
	static int[] count = new int[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt=0, i=1, index=-1;
		
		arr[1] = 1;
		int num = 2;
		for(int i1=2; i1<=1000000; i1++) { // 배열 채우기
			// 지금 숫자가 중복되는 수인지
			num += dupl(num); // 중복되는 갯수 반환
			arr[i1] = num++;
		}
		
		
		while (N != 0) { // 수 입력 받기
			System.out.println(arr[N]);

			N = Integer.parseInt(br.readLine());
		}
	}
	
	private static int dupl(int num) {
		boolean exit = false;
		int cnt = 0;
		int temp = num;
		while(!exit) {
			exit = true;
			Arrays.fill(count, 0);
			while(temp != 0) { // 현재 수에 중복 숫자가 있는지
				count[temp%10]++;

				if (count[temp%10] > 1) { // 중복 있다면 당장 멈춰
					num++;
					temp = num;
					exit = false;
					cnt++;
					break;
				}
				temp /= 10;
			}
			
		} 
		
		return cnt;
	}

}
