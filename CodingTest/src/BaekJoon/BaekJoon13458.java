package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon13458 { // 시험 감독 (B2)
    static int N, B, C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long result = N;
        for(int i=0; i<N; i++) {
            arr[i]-=B;
            if(arr[i]<=0) continue;
            result += arr[i]/C;
            if(arr[i] % C != 0) {
                result++;
            }
        }
        System.out.println(result);
    }

}