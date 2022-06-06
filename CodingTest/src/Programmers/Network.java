package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
	
	public static void main(String[] args) {
		int n=3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0,0,1}};
		System.out.println(solution(n, computers));
	}
	
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i=0; i<computers.length; i++) {
        	for(int j=0; j<computers[0].length; j++) {
        		if(computers[i][j]==1) {
        			bfs(i, j, computers);
        			answer++;
        		}
        	}
        }
        return answer;
    }

	private static void bfs(int x, int y, int[][] computers) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		
		while(!q.isEmpty()) {
			int net = q.poll();
			
			for(int k=0; k<computers[0].length; k++) {
				if(net == k) {
					computers[net][k]=0;
					computers[k][net]=0;
					continue;
				}
				if(computers[net][k]==1) {
					computers[net][k]=0;
					computers[k][net]=0;
					q.add(k);
				}
			}
		}
		
	}
}
