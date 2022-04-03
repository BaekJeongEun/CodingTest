package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1074 {
	static int n, r, c, count, ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		rec(0,0,(int)Math.pow(2, n),1<<n); // Math.pow 혹은 쉬프트 연산자 <<로 2의 거듭제곱 표현
		System.out.println(ans);
	}
	private static void rec(int startX, int startY, int endX, int endY) {
		
		// 목표 위치가 범위에 없다면 4등분하지 않아도 됨, 해당 크기만큼 더해서 바로 방문 처리
		if(startX>r||endX<=r || startY>c||endY<=c) { 
			count += (endX-startX)*(endY-startY);
			return;
		}
		// 더 이상 나누어지지 않다면
		if(endX-startX==1) { 
			// 목표 위치 도달!
			if(startX==r && startY==c) {
				ans = count;
			}
			count++;
			return;
		}
		// 4등분하여 다시 재귀 호출
		int midX = (endX+startX)/2;
		int midY = (endY+startY)/2;
		// 1사분면
		rec(startX,startY,midX, midY);
		// 2사분면
		rec(startX, midY, midX, endY);
		// 3사분면
		rec(midX, startY, endX, midY);
		// 4사분면
		rec(midX, midY, endX, endY);
	}
}
