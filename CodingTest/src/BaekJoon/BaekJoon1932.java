package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1932 { // 수학은 비대면강의입니다

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        
        int x=-1, y=-1;
        for(x=-999; x<=999; x++) {
        	for(y=-999; y<=999; y++) {
        		if(a*x + b*y == c && d*x + e*y ==f) {
        			System.out.println(x+" "+y);
        			return;
        		}
        	}
        }
	}

}
