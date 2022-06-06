package Programmers;

public class TargetNumber {

	static int cnt=0;
	public static void main(String[] args) {
		int[] numbers = {4, 1, 2, 1}; 
		int target = 2;
		System.out.println(solution(numbers, target));
	}
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(0,0, numbers, target);
        
        return cnt;
    }

	private static void dfs(int idx, int sum, int[] numbers, int target) {
		if(idx==numbers.length) {
			if(sum==target)
				cnt++;
			return;
		}
		
		dfs(idx+1, sum+numbers[idx], numbers, target);
		dfs(idx+1, sum-numbers[idx], numbers, target);
	}
	
	
}
