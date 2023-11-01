package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2740 { // 행렬 곱셈(S5)
	private static final int threshold = 16;
	 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
 
		// 행렬 A
		int[][] A = new int[128][128];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
 
		// 행렬 B 입력
		int[][] B = new int[128][128];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < K; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int big = Math.max(Math.max(N, K), M);
 
		int size = 1;
		while(true) {
			if(size >= big) {
				break;
			}
			size *= 2;
		}
 
		
		int[][] C = multiply(A, B, size);
 
		StringBuilder sb = new StringBuilder();
 
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				sb.append(C[i][j] + " ");
			}
			sb.append('\n');
		}
 
		System.out.println(sb);
	}
	
	public static int[][] loopMultiply(int[][] A, int[][] B, int size) {
 
		int res[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					res[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return res;
	}
 
	public static int[][] multiply(int[][] A, int[][] B, int size) {
 
 
		int[][] C = new int[size][size];	
		
		if (size <= threshold) {	
			return C = loopMultiply(A, B, size);
		}
 
 
		int newSize = size / 2;	
 
		int[][] a11 = subArray(A, 0, 0, newSize);
		int[][] a12 = subArray(A, 0, newSize, newSize);
		int[][] a21 = subArray(A, newSize, 0, newSize);
		int[][] a22 = subArray(A,newSize, newSize, newSize);
 
		int[][] b11 = subArray(B, 0, 0, newSize);
		int[][] b12 = subArray(B, 0, newSize, newSize);
		int[][] b21 = subArray(B, newSize, 0, newSize);
		int[][] b22 = subArray(B, newSize, newSize, newSize);
 
 
		int[][] M1 = multiply(add(a11, a22, newSize), add(b11, b22, newSize), newSize);
 
		int[][] M2 = multiply(add(a21, a22, newSize), b11, newSize);
 
		int[][] M3 = multiply(a11, sub(b12, b22, newSize), newSize);
 
		int[][] M4 = multiply(a22, sub(b21, b11, newSize), newSize);
 
		int[][] M5 = multiply(add(a11, a12, newSize), b22, newSize);
 
		int[][] M6 = multiply(sub(a21, a11, newSize), add(b11, b12, newSize), newSize);
 
		int[][] M7 = multiply(sub(a12, a22, newSize), add(b21, b22, newSize), newSize);
 
		
		int[][] c11 = add(sub(add(M1, M4, newSize), M5, newSize), M7, newSize);
 
		int[][] c12 = add(M3, M5, newSize);
 
		int[][] c21 = add(M2, M4, newSize);
 
		int[][] c22 = add(add(sub(M1, M2, newSize), M3, newSize), M6, newSize);
 
 
		merge(c11, C, 0, 0, newSize);
		merge(c12, C, 0, newSize, newSize);
		merge(c21, C, newSize, 0, newSize);
		merge(c22, C, newSize, newSize, newSize);
 
 
		return C;
	}
 
	public static int[][] sub(int[][] A, int[][] B, int size) {
 
		int[][] C = new int[size][size];
 
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				C[i][j] = A[i][j] - B[i][j];
			}
		}
		return C;
	}
 
	public static int[][] add(int[][] A, int[][] B, int size) {
 
		int n = size;
 
		int[][] C = new int[n][n];
 
		for (int i = 0; i < n; i++) {
 
			for (int j = 0; j < n; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;
	}
	
 
	public static int[][] subArray(int[][] src, int row, int col, int size) {
 
		int[][] dest = new int[size][size];
		for (int dset_i = 0, src_i = row; dset_i < size; dset_i++, src_i++) {
			for (int dest_j = 0, src_j = col; dest_j < size; dest_j++, src_j++) {
				dest[dset_i][dest_j] = src[src_i][src_j];
			}
		}
		return dest;
	}
	public static void merge(int[][] src, int[][] dest, int row, int col, int size) {
 
		for (int src_i = 0, dest_i = row; src_i < size; src_i++, dest_i++) {
			for (int src_j = 0, dest_j = col; src_j < size; src_j++, dest_j++) {
 
				dest[dest_i][dest_j] = src[src_i][src_j];
			}
		}
	}

}
