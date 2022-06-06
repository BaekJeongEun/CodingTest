package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortKNumber {

	public static void main(String[] args) {
		int array[] = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};	
		
		solution(array, commands);
	}
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int s = commands[i][0];
            int e = commands[i][1];
            int k = commands[i][2];
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<e-s+1; j++){
                temp.add(array[s+j-1]);
            }
            Collections.sort(temp);
            answer[i] = temp.get(k-1);
        }
        return answer;
    }

}
