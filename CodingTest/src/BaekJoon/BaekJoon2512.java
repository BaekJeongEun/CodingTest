package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2512 { // 예산(S2)
	static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int high = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i]; 
            high = Math.max(high, arr[i]); 
        }

        int max = Integer.parseInt(br.readLine());

        if (sum <= max) {
            System.out.println(high);
            return;
        }

        int low = 1;

        while (low < high - 1) {
            int mid = (low + high) / 2;
            
            if (count(mid) > max) {
                high = mid;
            } else {
                low = mid; 
            }
        }

        System.out.println(low);
    }

    static int count(int h) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(arr[i], h);
        }
        return total;
    }
}
