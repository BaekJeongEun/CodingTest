package Programmers;

public class TakePicture {
	static int N;
	static String member = "ACFJMNRT"; 
	static boolean visited[];
	static String[] dataList;
	static int total, count;
	public static void main(String[] args) {
		System.out.println(solution(2, new String[] {"N~F=0", "R~T>2"}));
	}
	public static int solution(int n, String[] data) {
        N = n;
        
        visited = new boolean[8];
        dataList = new String[data.length];
        
        dataList = data;
        dfs("");
        return total;
    }
	
	public static void dfs(String names) {
		if(names.length() == 7) {
			if(check(names))
				total++;
			return;
		}
		System.out.println("S "+names);
		for(int i=0; i<8; i++) {
			if(!visited[i]) {
				visited[i] = true;
				String name = names + member.charAt(i);
				dfs(name);
				visited[i] = false;
			}
		}
	}
	public static boolean check(String s) {
		for(int i=0; i<N; i++) {
			int position1 = s.indexOf(dataList[i].charAt(0)); // 포지션1
            int position2 = s.indexOf(dataList[i].charAt(2)); // 포지션2
            char op = dataList[i].charAt(3); // 수식
            int index = dataList[i].charAt(4) -'0'; // 간격
            if (op == '=') {
                if (!(Math.abs(position1 - position2) == index+1)) return false;
            } else if (op == '>') {
                if (!(Math.abs(position1 - position2) > index+1)) return false;
            } else if (op == '<') {
                if (!(Math.abs(position1 - position2) < index+1)) return false;
            }
		}
        return true;
	}
}
