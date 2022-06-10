package Programmers;

public class Gymsuit {
	static int arr[];
	public static void main(String[] args) {
		int lost[] = {3};
		int reserve[] = {1};
		System.out.println(solution(3, lost, reserve));

	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        arr = new int[n+1];
        for(int i=0; i<reserve.length; i++) {
        	arr[reserve[i]]++;
        }
        for(int i=0; i<lost.length; i++) {
        	arr[lost[i]]--;
        }
        
        for(int i=1; i<n; i++) {
        	if(arr[i]<0 && arr[i+1]>0) {
        		arr[i]++;
        		arr[i+1]--;
        	}else if(arr[i]>0 && arr[i+1]<0) {
        		arr[i+1]++;
        		arr[i]--;
        	}
        }
        
        for(int i=1; i<=n; i++) {
        	if(arr[i]<0) {
        		answer++;
        	}
        }
        return n-answer;
    }

}
