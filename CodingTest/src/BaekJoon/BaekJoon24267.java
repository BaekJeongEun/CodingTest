package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon24267 { // 알고리즘의 수행 시간 6

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        int count = 0;

        for(int i = 1; i <= n-2; i++){
            for(int j = i+1; j <= n-1; j++){
                for(int k = j+1; k <= n; k++){
                    count++;
                }
            }
        }

        br.close();

        bw.write(count+"\n" + 3);
        bw.flush();
        bw.close();

	}

}
