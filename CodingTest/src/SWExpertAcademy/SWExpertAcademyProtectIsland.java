package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWExpertAcademyProtectIsland { // 섬지키기
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			init(6, new int[][] {{1, 2, 1, 5, 5, 5},{3, 1, 3, 1, 1, 5}, {1, 4, 5, 5, 5, 5},{2, 1, 1, 1, 4, 5},{1, 4, 5, 5, 5, 5},{3, 2, 3, 4, 1, 2}});
			System.out.println(numberOfCandidate(3, new int[]{4, 3, 4}));
			System.out.println(numberOfCandidate(1, new int[]{4}));
		}

	}
	
	private static void init(int n, int[][] mMap) {
		N = n;
		map = new int[N+2][N+2];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = mMap[i-1][j-1];
			}
		}
	}
	private static int numberOfCandidate(int M, int mStructure[]) {
		int result = 0;		
		int[] reverse = new int[M];
		for(int i=M-1; i>=0; i--) {
			reverse[M-i-1] = mStructure[i];
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] > 0) {
					if(M == 1) {
						result++;
						continue;
					}
					boolean build = false;
					int rotation0 = checkIsland(i, j, mStructure, 0);// 0 => 배열 파라미터로 넘김
					result += rotation0;
					if(rotation0 == 1) build = true;
					if(!build) {
						int rotation90 = checkIsland(i, j, reverse, 0);// 180 전환 => 전환
						result += rotation90;
					}
					build = false;
					int rotation180 = checkIsland(i, j, mStructure, 1);// 90 전환 => y축으로 비교
					result += rotation180;
					if(rotation180 == 1) build = true;
					if(!build) {
						int rotation270 = checkIsland(i, j, reverse, 1);// 270 전환 => 전환 후 y축 비교 
						result += rotation270;
					}
				}
			}
		}
		return result;
	}
	private static int checkIsland(int startX, int startY, int[] mStructure, int axis) {
		int sum = -1;
		if(axis == 0) {
			for(int i=0; i<mStructure.length; i++) {
				if(startY+i > N || map[startX][startY+i] <= 0) { // 현재 칸이 범위 벗어나거나 섬이 아니라면
					return 0;
				}
				if(i == 0) {
					sum = map[startX][startY+i] + mStructure[i];
				}
				else {
					int nextSum = map[startX][startY+i] + mStructure[i];
					if(sum != nextSum) {
						return 0;
					}
				}
			}
		} else {
			for(int i=0; i<mStructure.length; i++) {
				if(startX +i > N || map[startX+i][startY] <= 0) { // 범위 내이고, 바로 옆이 섬이라면
					return 0;
				}
				if(i == 0) {
					sum = map[startX+i][startY] + mStructure[i];
				}
				else {
					int nextSum = map[startX+i][startY] + mStructure[i];
					if(sum != nextSum) {
						return 0;
					}
				}
			}
		}
		return 1;
	}

	/**
	 * M : 구조물의 크기 (1 ≤ M ≤ 5)
	 * mStructure : 구조물의 각 부분의 높이 (1 ≤ mStructure[] ≤ 5)
	 * mSeaLevel : 해수면의 상승 폭 (1 ≤ mSeaLevel ≤ 10)
	 * 실제로 해수면 상승하여 섬 잠김
	 * */
	private static int maxArea(int M, int mStructure[], int mSeaLevel) {
		int result = Integer.MIN_VALUE;
		int[] reverse = new int[M];
		for(int i=M-1; i>=0; i--) {
			reverse[M-i-1] = mStructure[i];
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] > 0) {
					int rotation0 = checkIsland(i, j, mStructure, 0);// 0 => 배열 파라미터로 넘김
					if(rotation0 == 1) {
						result = Math.max(result, checkWater(i, j, mStructure, 0));
					}
					int rotation90 = checkIsland(i, j, reverse, 0);// 180 전환 => 전환
					if(rotation90 == 1) {
						result = Math.max(result, checkWater(i, j, reverse, 0));
					}
					int rotation180 = checkIsland(i, j, mStructure, 1);// 90 전환 => y축으로 비교
					if(rotation180 == 1) {
						result = Math.max(result, checkWater(i, j, mStructure, 1));
					}
					int rotation270 = checkIsland(i, j, reverse, 1);// 270 전환 => 전환 후 y축 비교 
					if(rotation270 == 1) {
						result = Math.max(result, checkWater(i, j, reverse, 1));
					}
				}
			}
		}
		return result;
	}

	private static int checkWater(int i, int j, int[] mStructure, int k) {
		int sum = 0;
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {0,0});
		
		return sum;
	}
}
