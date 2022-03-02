package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1173 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N,m,M,T,R;
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        m = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        T = Integer.parseInt(st.nextToken());
	        R = Integer.parseInt(st.nextToken());
	        
	        int count = 0;
	        int time = 0;
	        int current = m;
//	        System.out.println(current);
	        while(count<N) {
	            if(current+T <= M) {	// � ����	
	                count++;
	                time++;
	                current += T;
	            }else {					// �޽�
	                if((current - R)< m) {	// ���� �ɹں��� �������ٸ�
	                    time++;
	                    current = m ;
	                }else {					// �޽��ص� �ɹڼ��� �������̶��
	                    time++;
	                    current -= R;
	                }
	            }
	            
	            if(current + T > M && current == m) {
	                System.out.println("-1");
	                return;
	            }
	                
//	            System.out.println(current);
	        }
		System.out.println(time);
	}

}
