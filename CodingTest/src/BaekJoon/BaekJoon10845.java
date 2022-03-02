package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<String> qu = new LinkedList<String>(); 
		int TC = Integer.parseInt(br.readLine());
		
		for(int i=0; i<TC; i++) {
			String str[] = br.readLine().split(" ");
			if(str[0].equals("push")) {
				qu.add(str[1]);
			}else if(str[0].equals("pop")) {
				String item = qu.poll();
				System.out.println(item==null?"-1":item);
			}else if(str[0].equals("size")) {
				System.out.println(qu.size());
			}else if(str[0].equals("empty")) {
				System.out.println((qu.isEmpty())?"1":"0");
			}else if(str[0].equals("front")) {
				String item = qu.peek();
				System.out.println(item==null?"-1":item);
			}else if(str[0].equals("back")) {
				String item = qu.peekLast();
				System.out.println(item==null?"-1":item);
			}
		}

	}

}
