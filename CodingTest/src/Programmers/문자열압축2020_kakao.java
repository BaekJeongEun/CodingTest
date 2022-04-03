package Programmers;

public class 문자열압축2020_kakao {
	public static void main(String[] args) {
		String s = "a";

		int answer = 0;
		int max_sep = s.length();
		int result = 10000;

		if (s.length() == 1) {
			result = 1;
			return;
		}
		for (int sep = 1; sep <= max_sep / 2; sep++) {
			int cnt = 1;
			String temp_s = s;
			String new_s = "", pre_s = "";
			pre_s = temp_s.substring(0, sep);
			temp_s = temp_s.substring(sep, temp_s.length());

			while (true) {
				// 구분자와 같은 경우
				if (pre_s.equals(temp_s.substring(0, sep))) {
					temp_s = temp_s.substring(sep, temp_s.length());
					cnt++;
				}
				// 구분 단위와 다르다면 새로운 구분 단위로 갱신
				else {
					if (cnt == 1)
						new_s += pre_s;
					else
						new_s += cnt + pre_s;
					pre_s = temp_s.substring(0, sep);
					temp_s = temp_s.substring(sep, temp_s.length());
					cnt = 1;
				}

				if (temp_s.length() < sep) {
					if (cnt == 1)
						new_s += pre_s + temp_s;
					else
						new_s += cnt + pre_s + temp_s;
					break;
				}
			}

			result = (result > new_s.length()) ? new_s.length() : result;
		}
		System.out.println(result);
	}
}
