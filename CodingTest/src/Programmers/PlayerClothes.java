package Programmers;

import java.util.HashSet;

public class PlayerClothes {

	public static void main(String[] args) {
		int lost[] = {2,4};
		int reserve[] = {1,3,5};
		System.out.println(solution(5, lost, reserve));
	}

	static public int solution(int n, int[] lost, int[] reserve) {
		HashSet<Integer> lostSet = new HashSet<>();
		HashSet<Integer> reserveSet = new HashSet<>();
		// 체육복 남는 인원
		for(int i : reserve)
			reserveSet.add(i);
		// 체육복 도난 당한 인원
		for(int i : lost) {
			if(reserveSet.contains(i)) // 체육복 남는 인원이 도난 당했을 경우
				reserveSet.remove(i); // 내 체육복만 남게 됨
			else
				lostSet.add(i);
		}
		// 체육복 남는 인원 중 양 옆 사람이 도난 당한 사람일 경우 빌려주기
		for(int i : reserveSet) {
			if(lostSet.contains(i-1))
				lostSet.remove(i-i);
			else if(lostSet.contains(i+1))
				lostSet.remove(i+1);
		}
		
        return n-lostSet.size();
    }
}
