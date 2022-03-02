package BaekJoon;
// 셀프 넘버, 실버 5
public class BaekJoon4673 {

	public static void main(String[] args) {
		int arr[] = new int[10001];
		int sum=0;
				
		for(int i=1; i<=10000; i++) {
			sum = i + i/1000 + (i/100)%10 + (i/10)%10 + i%10;
			if(sum <= 10000)
				arr[sum] = -1;

		}
		for(int i=1; i<=10000; i++) {
			if(arr[i] != -1) {
				System.out.println((i));
			}
		}
	}
}