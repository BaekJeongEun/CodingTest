package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon2941 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String croat[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
		String str = br.readLine().trim();
		for(int i=0; i<croat.length; i++) {
			if(str.contains(croat[i])) {
				str = str.replaceAll(croat[i], " ");
			}
		}
		bw.write(String.valueOf(str.length()));
		bw.flush();
		bw.close();
	}
}
// ljes=njak   6
// ddz=z=      3
/*

package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon2941 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str[] = br.readLine().split("");
		String croat[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		int count=0;
		int j = 0;
		for(int i=0; i<str.length; i++) {
			for(j=0; j<croat.length; j++) {
				//System.out.println(str[i] + ", "+croat[j].charAt(0) + " equls1? "+str[i].equals(String.valueOf(croat[j].charAt(0))));
				if(str[i].equals(String.valueOf(croat[j].charAt(0))) && i<str.length){
					i++;
					if(str[i].equals(String.valueOf(croat[j].charAt(1))) && i<str.length) {
						//System.out.println(str[i] + ", "+croat[j].charAt(1) + " equls2? "+str[i].equals(String.valueOf(croat[j].charAt(1))));
						i++;
						count++;
						if(croat[j].equals("dz=") && str[i].equals(String.valueOf(croat[j].charAt(2))) && i<str.length) {
							//System.out.println(str[i] + ", "+croat[j].charAt(2) + " equls2? "+str[i].equals(String.valueOf(croat[j].charAt(2))));
							i++;
						}else {
							i--;
							break;
						}
					}else { // 한 글자만 맞는 경우
						i--;
						count++;
						break;
					}
				}
				
			}if(j == croat.length) {
				count++;
			}
		}
		System.out.println(count);
		
	}

}
// ljes=njak   6
// ddz=z=      3

*/