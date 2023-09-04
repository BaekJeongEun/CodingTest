package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon24313 { // 알고리즘 수업 - 점근적 표기1(S1)

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        int n = 1;
        br.close();

        boolean result = true;
        
        while(n <= n0){
            if(a1*n0 + a0 > c*n0){
                result = false;
                break;
            }
            n++;
        }

        if(result) {
            bw.write(1 + "");
        }else{
            bw.write(0 + "");
        }
        bw.flush();
        bw.close();

    }

}
