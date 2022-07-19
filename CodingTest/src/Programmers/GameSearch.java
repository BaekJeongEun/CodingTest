package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class GameSearch { // 게임 맵 최단거리
	public static void main(String[] args) {
		System.out.println("답 "+solution(new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}}));
		System.out.println("답 "+solution(new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}}));

	}
	public static int solution(int[][] maps) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
        int answer = Integer.MAX_VALUE;
        Queue<Point> queue = new LinkedList<>();
        int nowX = 0, nowY=0, count=0;
        queue.add(new Point(0,0,1));
        
        while(!queue.isEmpty()) {
        	
        	//for(int s=0; s<size; s++) {
        		Point now = queue.poll();
            	nowX = now.x;
            	nowY = now.y;
            	count = now.count;
            	
            	if(nowX == maps.length-1 && nowY == maps[0].length-1) {
            		answer = (answer > count) ? count : answer;
            		break;
            	}
            	for(int i=0; i<4; i++) {
            		int nextX = nowX + dx[i];
            		int nextY = nowY + dy[i];
            		System.out.println(nextX +" "+nextY);
            		if(nextX>=0 && nextX<= maps.length-1 && nextY>=0 && nextY<=maps[0].length-1 && maps[nextX][nextY]==1) {
            			maps[nextX][nextY] = 0;
            			queue.add(new Point(nextX, nextY, count+1));
            		}
            	}
        	//}
        }
        
        return (Integer.MAX_VALUE==answer)?-1:answer;
    }	
	
	public static class Point{
		int x, y, count;
		public Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
