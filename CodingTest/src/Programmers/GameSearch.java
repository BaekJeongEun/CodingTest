package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class GameSearch {
	public static void main(String[] args) {
		System.out.println("답 "+solution(new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}}));
		System.out.println("답 "+solution(new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}}));

	}
	public static int solution(int[][] maps) {
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
        int answer = 0;
        boolean exit = false;
        Queue<Point> queue = new LinkedList<>();
        int nowX = 0, nowY=0;
        queue.add(new Point(0,0));
        
        while(!queue.isEmpty() && !exit) {
        	
        	int size = queue.size();
        	answer++;
        	System.out.println("size "+size);
        	for(int s=0; s<size; s++) {
        		Point now = queue.poll();
            	nowX = now.x;
            	nowY = now.y;
            	
            	if(nowX == maps.length-1 && nowY == maps[0].length-1) {
            		exit = true;
            		break;
            	}
            	for(int i=0; i<4; i++) {
            		int nextX = nowX + dx[i];
            		int nextY = nowY + dy[i];
            		System.out.println(nextX +" "+nextY);
            		if(nextX>=0 && nextX<= maps.length-1 && nextY>=0 && nextY<=maps[0].length-1 && maps[nextX][nextY]==1) {
            			queue.add(new Point(nextX, nextY));
            			maps[nextX][nextY] = 0;
            		}
            	}
        	}
        }
        
        return exit?answer:-1;
    }	
	
	public static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
