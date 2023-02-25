package Programmers;

import java.util.Stack;

public class StockPrice { // 주식가격 (L2)

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 2, 3 }).toString());

	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
				answer[stack.peek()] = i - stack.peek();
				stack.pop();
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			answer[stack.peek()] = prices.length - stack.peek() - 1;
			stack.pop();
		}
		return answer;
	}
}
