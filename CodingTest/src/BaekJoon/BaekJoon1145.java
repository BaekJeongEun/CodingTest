package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 적어도 대부분의 배수, 브1
public class BaekJoon1145 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[5]; // 입력 받은 수
		int common_multiple[] = new int[10]; // 공배수 10개
		int cnt = 0;

		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 3; i++) {
			for (int j = i + 1; j < 4; j++) {
				for (int k = j + 1; k < 5; k++) {
					// 공배수 구해주는 함수
					common_multiple[cnt++] = multiple(arr[i], arr[j], arr[k]);
					
				}
			}
		}
		Arrays.sort(common_multiple);
		System.out.println(common_multiple[0]);
	}

	public static int multiple(int a, int b, int c) {
		//int max = (a>b)?(b>c)?a:b:c;	// 가장 큰 값 구하기
		int max=0, num1=0, num2=0, leastCommonMuliple=0, cnt=2;
		if(a>b) {
			if(a>c) {
				max = a;
				num1 = b; num2 = c;
			}else {
				max = c;
				num1 = a; num2 = b;
			}
		}else {
			if(b>c) {
				max = b;
				num1 = a; num2 = c;
			}else {
				max = c;
				num1 = a; num2 = b;
			}
		}
		for(int i=max; ; i=max*(cnt++)) {
			if(i%num1==0 && i%num2==0) {
				leastCommonMuliple = i;
				break;
			}
		}
		System.out.println(leastCommonMuliple);
		return leastCommonMuliple;
	}

}
