package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWExpert1210 { // Ladder1 (D4)
	static int[][] arr, dir = {{1,0},{0,-1},{0,1}}; // 하 좌 우
	static int currentX = 0, currentY=0;
	static boolean exit = false;
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		arr = new int[100][100];
		ArrayList<Integer> list = null;
		
		for(int tc=1; tc<= 10; tc++) {
			String temp = br.readLine();
			list = new ArrayList<>();
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					//System.out.print(arr[i][j]);
					if(i==0 && arr[i][j] == 1) {
						list.add(j);
					}
				}
			}
			for(int start=0; start<list.size(); start++) {
				
				//System.out.println("start "+start);
				
				currentX = 0;
				currentY = list.get(start);
				int direction = 0;
				exit = false;
				while(!exit) {
					//System.out.println(currentX+" "+currentY +" "+direction);
					if(direction==0) { // 아래
						if(Check(1)) { // 좌
							direction = 1;
						}else if(Check(2)) { // 우
							direction = 2;
						}else if(Check(0)) { // 아래
							direction = 0;
						}
					}
					else if(direction==1) { // 좌
						if(Check(0)) { // 아래
							direction = 0;
						}else if(Check(1)) { // 좌
							direction = 1;
						}
					}
					else if(direction==2) { // 우
						if(Check(0)) { // 아래
							direction = 0;
						}else if(Check(2)) { // 우
							direction = 2;
						}
					}
				}

				if(arr[currentX][currentY] == 2) {
					System.out.println("#"+tc+" "+list.get(start));
					break;
				}
			}
			
		}
	}
	
	static boolean Check(int direction) {
		boolean go = false;
		
		int X = currentX+dir[direction][0];
		int Y = currentY+dir[direction][1];
		
		if(X == 99 && Y>=0 && Y<100) {
			//System.out.println("===============================================");
			
			currentX = X;
			currentY = Y;
			
			exit = true;
			return true;
		}
		
		if(X>=0 && X<100 && Y>=0 && Y<100 && arr[X][Y]==1) {
			currentX = X;
			currentY = Y;
			go = true;
			
			//System.out.println("new "+currentX+" "+currentY);
		}
		
		return go;
	}
}
