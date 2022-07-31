package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon7696 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt=0, i=1, index=-1, num=0;
		boolean exit = false;
		String str = "";
		int[] arr = new int[10];
		while (N != 0) { // 수 입력 받기
			cnt = 0;
			for (i = 1; cnt != N; i++) { // 카운트 셀 거임, 카운트가 타겟 숫자 N이 될 때까지 반복
				Arrays.fill(arr, 0);
				exit = false;
				num = i;
				while(num != 0) { // 현재 수에 중복 숫자가 있는지
					index = num%10;
					arr[index]++;
					//System.out.println(num+"  "+index);
					num /= 10;
					if (arr[index] > 1) { // 중복 있다면 당장 멈춰
						exit = true;
						break;
					}
				}
				if (!exit) { // 중복 없었다면 카운트해줌, 중복 있었으면 카운트 안 쳐줌! 다시 돌아
					cnt++;
				}
			}
			System.out.println(i-1);

			N = Integer.parseInt(br.readLine());
		}
	}

}
