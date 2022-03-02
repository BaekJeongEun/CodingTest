package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon11720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split("");
		int sum=0;
		
		for(int i=0; i<TC; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		bw.write(String.valueOf(sum));
		bw.close();
	}
}

/*
 * 
 * 
 * 
 * 
 * 
 package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon11720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		int sum=0;
		
		for(int i=0; i<TC; i++) {
			sum += br.read() - 48;
			// sum += br.read() - '0';
		}
		bw.write(String.valueOf(sum));
		bw.close();
	}
}
 
 
 
 package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon11720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		long N = Long.parseLong(br.readLine());
		long sum=0;
		
		for(int i=0; i<TC; i++) {
			long remainder = (N%10);
			sum += remainder;
			N = N / 10;		
		}
		System.out.println(sum);
	}
}

 * */
 