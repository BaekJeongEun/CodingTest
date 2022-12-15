package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon1251 { // 단어 나누기 (S5)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] temp = new String[3];
		ArrayList<String> list = new ArrayList<>();
		for(int i=1; i<input.length()-1; i++) {
			for(int j=i+1; j<input.length(); j++) {
				temp[0] = input.substring(0, i);
				temp[1] = input.substring(i, j);
				temp[2] = input.substring(j, input.length());
				
				StringBuilder sb = new StringBuilder();
				for(int k=0; k<3; k++) {
					for(int l=temp[k].length()-1; l>=0; l--) {
						sb.append(Character.toString(temp[k].charAt(l)));
					}
				}
				list.add(sb.toString());
				sb.setLength(0);
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}

}
