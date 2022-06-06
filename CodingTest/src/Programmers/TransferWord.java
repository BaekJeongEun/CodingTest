package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;

public class TransferWord {
	static int answer = 0;
	static boolean[] visited;
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}

	public static int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		boolean exit = true;
		ArrayList<String> temp = new ArrayList();
		for (int i = 0; i < words.length; i++) {
			if (target.equals(words[i]))
				exit = false;
			temp.add(words[i]);
		}
		if (!exit)
			dfs(begin, 0, target, temp);
		return answer;
	}

	private static void dfs(String current, int cnt, String target, ArrayList<String> words) {

		if (target.equals(current)) {
			answer = cnt;
			return;
		}

		ArrayList<String> temp = words;
		int target_idx = 0;
		for (int i = 0; i < temp.size(); i++) {
			int same = 0;
			if(visited[i]) continue;
			for (int k = 0; k < current.length(); k++) {// 한 글자씩 비교
				if (temp.get(i).charAt(k) == current.charAt(k)) {
					same++;
				}
			}
			if (same == current.length()-1) {
				visited[i] = true;
				dfs(temp.get(i), cnt + 1, target, temp);
				visited[i] = false;
			}

		}
	}

}
