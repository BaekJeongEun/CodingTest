package Programmers;

import java.util.Arrays;

public class SecretMap {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6, new int[] {46, 33, 33 ,22, 31, 50}, new int[] {27 ,56, 19, 14, 14, 10})));
	}
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];
        for(int i=0; i<n; i++) {       	

        	String res = Integer.toBinaryString(arr1[i]|arr2[i]);
        	String s ="";
        	while(res.length()!=n) {
        		res = "0"+res;
        	}
        	for(int j=0; j<n; j++) {
        		if(res.charAt(j)=='1') {
        			s+="#";
        		}
        		else{
                    s+=" ";
                }
        		
        	}
        	
        	answer[i] = s;
        }
        
        return answer;
    }
}
