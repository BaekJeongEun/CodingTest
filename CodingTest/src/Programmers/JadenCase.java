package Programmers;

import java.util.Stack;

public class JadenCase {
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) {
		System.out.println(solution("(()("));
	}

	static boolean solution(String s) {
        boolean answer = true;
        for(int i=0; i<s.length(); i++) {
        	char now = s.charAt(i);
        	if(now == '(') {
        		stack.add(now);
        	}else if(!stack.isEmpty() && now == ')') {
        		stack.pop();
        	}else answer = false;
        }
        if(!stack.isEmpty()) answer = false;
        return answer;
    }

}
