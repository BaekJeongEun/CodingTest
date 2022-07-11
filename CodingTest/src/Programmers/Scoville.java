package Programmers;

import java.util.PriorityQueue;

public class Scoville {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int i = 0; i < scoville.length; i++) {
			heap.offer(scoville[i]);
		}

		while (heap.peek() < K) {
			if (heap.size() < 2)
				return -1;
			int f1 = heap.poll();
			int f2 = heap.poll();

			int newFood = f1 + (f2 * 2);
			heap.offer(newFood);
			answer++;
		}

		return answer;
	}

}
