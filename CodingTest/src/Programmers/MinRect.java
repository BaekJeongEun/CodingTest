package Programmers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MinRect {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{60,50},{30,70},{60,30},{80,40}}));
	}
	public static int solution(int[][] sizes) {
		int answer = 0;
        int max_v=0;
        int max_h=0;
        for(int i=0;i<sizes.length;i++){
            int v=Math.max(sizes[i][0],sizes[i][1]);
            int h=Math.min(sizes[i][0],sizes[i][1]);
            max_v=Math.max(max_v,v);
            max_h=Math.max(max_h,h);
        }
        return answer=max_v*max_h;
    }
}
