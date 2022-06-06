package Programmers;

import java.util.*;
class MakePrimeNumber {
    static int cnt;
    static int N;
    static int arr[];
    static ArrayList<Integer> set = new ArrayList<>();
    public static void main(String[] args) {
    	int nums[] = {1,2,7,6,4};
    	System.out.println(solution(nums));
	}
    public static int solution(int[] nums) {
        int answer = -1;
        N = nums.length;
        arr = new int[3];
        comb(0,0, nums);

        return set.size();
    }
    public static void comb(int cnt, int idx, int[] nums){
        if(cnt==3){
            int sum=0;
            boolean prime = true;
            for(int i=0; i<3; i++){
                sum += arr[i];
            }
            System.out.println(sum);
            // 소수 판별
            for(int i=2; i<=Math.sqrt(sum); i++){
                if(sum%i==0){
                    prime = false;
                    break;
                }
            }
            if(prime){
            	set.add(sum);
            }
            return;
        }
        for(int i=idx; i<N; i++){
            arr[cnt] = nums[i];
            comb(cnt+1, i+1, nums);
        }
    }
}