package Programmers;

import java.util.Arrays;

public class MatrixRotate { // 행렬과 연산
	public static void main(String[] args) {
		int[][] temp = solution(new int[][] {{1,2,3}, {4,5,6}, {7,8,9}}, new String[] {"Rotate", "ShiftRow"});
		for(int i=0; i<temp.length; i++) {
			System.out.println(Arrays.toString(temp[i]));
		}
	}

	static public int[][] solution(int[][] rc, String[] operations) {
        
        for(int i=0; i<operations.length; i++) {
        	if(operations[i].equals("Rotate")) {
        		rc = rotate(rc);
        	}else {
        		rc = shiftRow(rc);
        	}
        }      
        
        return rc;
    }
	static public int[][] rotate(int[][] rc) {
		int dir[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
		int preX = 0, preY = 0, N = rc.length, M = rc[0].length, d=0;
		int nextX = preX, nextY = preY;
		int first = rc[0][0];
		while(true) {
			nextX = preX + dir[d][0];
			nextY = preY + dir[d][1];
			if(nextX <0 || nextY < 0 || nextX >= N || nextY >= M) {
				d++;
				nextX = preX + dir[d][0];
				nextY = preY + dir[d][1];
			}
			rc[preX][preY] = rc[nextX][nextY];
			preX = nextX; preY = nextY;
			if(preX == 0 && preY == 1) break;
		}
		rc[0][1] = first;
		return rc;
	}
	static public int[][] shiftRow(int[][] rc) {
		int[] temp = rc[rc.length-1]; // 마지막 배열 담아놓기
		for(int i=rc.length-1; i>0; i--) {
			rc[i] = rc[i-1];
		}
		rc[0] = temp;
		return rc;
	}
}
