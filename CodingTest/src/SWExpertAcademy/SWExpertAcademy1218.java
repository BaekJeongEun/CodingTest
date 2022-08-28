package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SWExpertAcademy1218 { // 괄호 짝짓기 (D4)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<String> stack;
		int N, result=1;
		String input, temp;
		for(int tc=1; tc<= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			input = br.readLine();
			stack = new Stack<>();
			result=1;
			String get = input.charAt(0)+"";
			if(input.length()%2!=0) 
				result = 0;
			else {
				stack.push(get);
				for(int i=1; i<N; i++) {
					if(!stack.empty()) {
						temp = stack.peek();
						get = input.charAt(i)+"";
						
						if(get.equals("}") || get.equals(")") || get.equals(">") || get.equals("]")){
							if(!check(temp, get)) { // 짝이 안 맞으면
								result = 0;
								break;
							}else { // 짝이 맞으면
								stack.pop();
								continue;
							}
						}
						stack.push(get);
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}

	}
	
	private static boolean check(String pop, String str) { // 닫는 괄호 가져오기
		boolean success = false;
		
		if(pop.equals("{") && str.equals("}")
				|| pop.equals("[") && str.equals("]")
				|| pop.equals("(") && str.equals(")")
				|| pop.equals("<") && str.equals(">")
				) {
			success = true;
		}
		return success;
	}

}
