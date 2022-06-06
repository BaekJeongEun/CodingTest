package Programmers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TravelRoute {
	static boolean visit[];
	static ArrayList<String> set = new ArrayList<>();

	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}};
		visit = new boolean[tickets.length];
		solution(tickets);
	}

	public static String[] solution(String[][] tickets) {

		visit = new boolean[tickets.length];
		bfs("ICN", tickets, 0, "ICN");

		
		String[] answer = new String[set.size()];
		int i = 0;
		Collections.sort(set);
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String ss = answer[i++] = iter.next();
			System.out.println("=> "+ss);
		}

		return answer;
	}

	private static void bfs(String start, String[][] tickets, int cnt, String route) {
		if(cnt == tickets.length){
			set.add(route);
            return;
        }
		ArrayList<String> arr = new ArrayList<>();
		set.add(start);
		for (int i = 0; i < tickets.length; i++) {
			if (visit[i])
				continue;

			if (tickets[i][0].equals(start)) {
				System.out.println("동일한 것 "+tickets[i][1]+" "+start);
				visit[i] = true;
				bfs(tickets[i][1], tickets, cnt+1, route+" "+tickets[i][1]);
				visit[i] = false;
			}

		}
		
	}

}
