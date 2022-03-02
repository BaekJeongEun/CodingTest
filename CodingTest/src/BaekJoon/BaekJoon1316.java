package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		int cnt = TC;
		String str[] = new String[TC];
		
		for (int i = 0; i < TC; i++) {
			str[i] = br.readLine();

			String newString = "";
			for (int j = 0; j < str[i].length(); j++) {
				if(newString.contains(""+str[i].charAt(j))) {	// ���� ���� ���� ������
					if(!(str[i].charAt(j)==newString.charAt(newString.length()-1))) {  // ���� ���� ������ ������ ���ڶ� �ٸ��ٸ�
						cnt--;
						break;
					}
				}
				newString += str[i].charAt(j);
			}
		}
		System.out.println(cnt);

	}

}
