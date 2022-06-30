package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpertAcademy1959 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	int[] arrA = new int[A];
        	int[] arrB = new int[B];
        	
        	int sum = 0, max=0;
        	
        	st = new StringTokenizer(br.readLine());
        	for(int a=0; a<A; a++) {
        		arrA[a] = Integer.parseInt(st.nextToken());
        	}
        	st = new StringTokenizer(br.readLine());
        	for(int b=0; b<B; b++) {
        		arrB[b] = Integer.parseInt(st.nextToken());
        	}
        	
        	int loop = Math.max(A, B) - Math.min(A, B) + 1;
        	for(int i=0; i<loop; i++) {
        		sum=0;
        		for(int j=0; j<Math.min(A, B); j++) {
        			if(A<B)
        				sum += arrA[j]*arrB[i+j];
        			else
        				sum += arrA[i+j]*arrB[j];
        		}
        		max = Math.max(max, sum);
        	}
        	
        	System.out.println("#"+tc+" "+max);
        }
	}
}
