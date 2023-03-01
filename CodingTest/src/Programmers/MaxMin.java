package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxMin { // 최댓값과 최솟값 (L2)

	public static void main(String[] args) {
		System.out.println(solution("10 -1"));
	}
	public static String solution(String s) {
        String[] arr = s.split(" ");
        List<Integer> list =Arrays.stream(arr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return Collections.min(list) + " " + Collections.max(list);
	}
}
