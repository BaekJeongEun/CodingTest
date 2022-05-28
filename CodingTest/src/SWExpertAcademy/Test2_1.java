package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2_1 {

	static int[] arr;
	public static void main(String[] args)  throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		int target=0;
		
		for(int tc=0; tc<TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[Integer.parseInt(st.nextToken())+1];
			target = Integer.parseInt(st.nextToken());
			int loop = Integer.parseInt(st.nextToken());
			for(int i=0; i<loop; i++) {
				st = new StringTokenizer(br.readLine());
				int one = Integer.parseInt(st.nextToken());
				int two = Integer.parseInt(st.nextToken());
				if(one==target || two==target) {
					target = (one==target)?two:one;
				}
			}
			System.out.println("#"+(tc+1)+" "+target);
		}
	}

}
