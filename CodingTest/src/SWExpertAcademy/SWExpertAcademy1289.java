package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWExpertAcademy1289 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		String arr[] = new String[TC];
		int cnt = 0;

		StringBuilder st = new StringBuilder();

		for (int i = 0; i < TC; i++) {
			arr[i] = br.readLine();
			cnt = 0;
			st.delete(0, st.length());
			st.append(arr[i].replaceAll("1", "0"));
			for (int j = 0; j < st.length(); j++) {
				if (st.charAt(j) != arr[i].charAt(j)) {
					for (int k = j; k < st.length(); k++) {
						st.replace(k, k + 1, String.valueOf(arr[i].charAt(j)));
					}
					cnt++;
				}
			}
			System.out.println("#" + (i + 1) + " " + cnt);
		}
	}

}

/*
 * package test01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1289 {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int TC = Integer.parseInt(br.readLine());
      String str = null;
      char[] ch;
      int cnt = 0;
      
      
      for (int tc = 1; tc <= TC; tc++) {
         str = br.readLine();
         ch = str.toCharArray();

         if (ch[0] == '1')
            cnt++;
         for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] != ch[i + 1])
               cnt++;
         }
         
         System.out.println("#" + tc + " " + cnt);
         cnt = 0;
      }

   }
}
 */
