package BaekJoon;
import java.util.*;
import java.io.*;
public class BaekJoon15961 { // 회전 초밥(G4)

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] sushi = new int[N+2];
		boolean[] pick = new boolean[d+1];
		for(int i=1; i<=N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		int start = 0, end=0, max = Integer.MIN_VALUE, cnt = 0, totalCnt=0;
		while(start <= N+1) {			
			if(!pick[sushi[(end+1)%N]]) { // 다음 것이 안 뽑힌 상태라면
				if(cnt < k) { // 최대치보다 작을 때만 늘려줌
					end++;
					if(sushi[(end+1)%N] != c) { // 일반 초밥일 때만
						cnt++;
					}
					pick[sushi[(end+1)%N]] = true;
					totalCnt++;
					max = Math.max(max, totalCnt);
				}else if(cnt == k) { // 최대치 되면
					if(sushi[(end+1)%N] != c) { // 일반 초밥일 때만 당겨오기
						start++;
						totalCnt--;
						cnt--;
						pick[sushi[start%N]] = false;
					}else { // 공짜 초밥일 때
						totalCnt++; // 공짜일 경우 그냥 늘리기
						max = Math.max(max, totalCnt);
					}
				}
			}else { // 늘렸을 때 추가 불가하다면
				start++;
				cnt--;
				totalCnt--;
				pick[sushi[start%N]] = false;
			}
			System.out.println("totalCnt "+totalCnt);
			for(int i=1; i<=d; i++) {
				if(pick[i]) System.out.print(i+" ");
			}
			System.out.println();
		}
		sb.append(max);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
