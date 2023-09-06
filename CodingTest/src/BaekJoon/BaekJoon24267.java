package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon24267 { // 알고리즘의 수행 시간 5

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

        long n = Long.parseLong(br.readLine());

        System.out.println(n * n * n);
        System.out.println(3);
        br.close();

	}

}
