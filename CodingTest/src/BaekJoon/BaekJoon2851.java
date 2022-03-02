package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ½´ÆÛ ¸¶¸®¿À
public class BaekJoon2851 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		int sum=0, index=0;
		for(int i=0; i<10; i++) {
			int a = Integer.parseInt(br.readLine());
			arr[i] = a;
			if(sum <= 100) {
				sum+=arr[i];
				index = i;
			}
		}
		if(Math.abs(100-(sum-arr[index])) < Math.abs(100-sum)) {
			System.out.println(Math.abs(100-sum-arr[index])+", "+Math.abs(100-sum));
			sum = sum-arr[index];
		}
		System.out.println(sum);
	}

}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//// ½´ÆÛ ¸¶¸®¿À
//public class Sol2851 {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int[] arr = new int[10];
//		int sum=0, least=100, index=0;
//		for(int i=0; i<10; i++) {
//			int a = Integer.parseInt(br.readLine());
//			arr[i] = a;
//			if(Math.abs(100-sum) <= least) {
//				least = Math.abs(100-sum);
//				sum+=arr[i];
//				index=i;
//			}
//		}
//		System.out.println(sum-arr[index]);
//	}
//
//}
