package Programmers;

public class TakePicture {
	static int N;
	static String member = "ACFJMNRT"; 
	static boolean visited[];
	static String[] dataList;
	static int total;
	public static void main(String[] args) {
		System.out.println(solution(2, new String[] {"N~F=0", "R~T>2"}));

	}
	public static int solution(int n, String[] data) {
        N = n;
        dataList = data;
        String hello = "";
        dfs(hello);
        return total;
    }
	
	public static void dfs(String s) {
		if(s.length() == 8) {
			System.out.println("s "+s);
			check(s);
			
			return;
		}
		System.out.println("sss "+s);
		for(int i=0; i<8; i++) {
			System.out.println("member "+member.indexOf(i)+"     ? "+member);
			if(!visited[member.indexOf(i)]) {
				visited[member.indexOf(i)] = true;
				s += member.indexOf(i)+"";
				System.out.println("s111 "+s);
				dfs(s);
				visited[member.indexOf(i)] = false;
			}
		}
	}
	public static void check(String s) {
		int temp = 0;
		for(int i=0; i<N; i++) {
			if(Math.abs(s.indexOf(dataList[i].indexOf(0)) - s.indexOf(dataList[i].indexOf(2)))
					<= dataList[i].indexOf(4)) {
				temp++;
			}
		}
		if(temp == N) {
			total++;
		}
	}
}
