package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean trash = true;
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		while(queue.size()!=1) {
			if(trash) {
				queue.poll();
				trash = false;
			}
			else {
				int temp = queue.poll();
				queue.add(temp);
				trash = true;
			}
		}
		System.out.println(queue.poll());
	}

}
