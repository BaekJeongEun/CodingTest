package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Tuple {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
	}

	public static int[] solution(String s) {
		int[] answer = null;
		LinkedHashSet<Integer> map = new LinkedHashSet<>();
		s = s.substring(1, s.length() - 1);
		String arr[] = s.split("\\}");
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		for(int i=0; i<arr.length; i++) {
			arr[i] = arr[i].split("\\{")[1];
		}
		
		for (int i = 0; i < arr.length; i++) {
			String str[] = arr[i].split(",");
			for(int j=0; j<str.length; j++)
				map.add(Integer.parseInt(str[j]));
		}
		answer = map.stream().mapToInt(Integer::intValue).toArray();
		return answer;
	}
}