package Programmers;
// 두 수 뽑아서 더하기
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SumTwoNumber {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {2,1,3,4,1})));
	}

	public static int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> set = new TreeSet<>();
        for(int i=0; i<numbers.length; i++){
        	for(int j=1; j<numbers.length; j++) {
        		if(i!=j)
        			set.add(numbers[i]+numbers[j]);
        	}
        }
        answer = set.stream().mapToInt(Number::intValue).toArray();
        return answer;
    }
}
