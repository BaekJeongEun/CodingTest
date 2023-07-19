package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MenuRenewel { // 메뉴 리뉴얼 (L2)
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				solution(new String[] { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" }, new int[] { 2, 3, 5 })));

	}

	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};

		List<String> list = new ArrayList<>();

		for (int i = 0; i < orders.length; i++) {
			char[] ch = orders[i].toCharArray();
			Arrays.sort(ch);
			orders[i] = String.valueOf(ch);
		}
		// 주문한 메뉴들을 course 길이만큼 조합
		for (int c = 0; c < course.length; c++) {

			for (int o = 0; o < orders.length; o++) {
				if (orders[o].length() >= course[c]) {
					// 조합된 문자열, 목표 조합 길이, 주어진 문자열, 조합될 문자 인덱스
					//StringBuilder sb = new StringBuilder(); 
					comb(orders[o],"",0,0,course[c]);
				}
			}
			// map에 저장된 조합된 메뉴들 중 최댓값만 추출
			if (!map.isEmpty()) {
				List<Integer> menu = new ArrayList<>(map.values());
				int max = Collections.max(menu);

				System.out.println("course[c] "+course[c]);
				System.out.println("max "+max);
				if (max > 1) {
					for (String s : map.keySet()) {
						if (map.get(s) == max) {
							list.add(s);
						}
					}
				}
				map.clear();
			}
		}

		answer = list.toArray(new String[list.size()]);
		Arrays.sort(answer);
		return answer;
	}

	public static void comb(String str,String sb,int idx, int cnt, int n) {
		if (cnt == n) {
			map.put(sb,map.getOrDefault(sb,0)+1);
			return;
		}
		for (int i = idx; i < str.length(); i++) {
            sb += str.charAt(i);
            comb(str,sb,i+1,cnt+1,n);
            sb = sb.substring(0, sb.length() - 1);
		}
	}
}
