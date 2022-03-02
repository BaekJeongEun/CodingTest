package BaekJoon;
// �Ҽ� ���ϱ�, �ǹ� 2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1929_ {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int cnt=0;
		int j;
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		arr[0]=1;
		
		for(int i=M; i<=N; i++) {
			cnt=0;
			for(j=1; j<=i; j++) {
				if(i%j == 0) {	// ������ �������� ���
					cnt++;
				}
				if(cnt > 2)
					break;
			}
			if(cnt == 2) {
				System.out.println(i);
			}
		}
	}

}

/*
package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1929 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int cnt=0;
		int j;
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=M; i<=N; i++) {
			cnt=0;
			for(j=1; j<=i; j++) {
				if(i%j == 0) {	// ������ �������� ���
					cnt++;
				}
				if(cnt > 2)
					break;
			}
			if(cnt == 2) {
				System.out.println(i);
			}
		}
	}

}
*/