package Programmers;

class LonerAlphabet { // 외톨이 알파벳
	public static void main(String[] args) {
		System.out.println(solution("aabbaa"));
	}
    public static String solution(String input_string) {       
        int length = input_string.length();
        if(length <= 2) return "N";
        
        int alpha[] = new int[26];
        char before = input_string.charAt(0);
        for (int i = 1; i < length; i++) {
            char now = input_string.charAt(i);
            if(before != now) {
                alpha[before - 'a']++;
                before = now;
            }
        }
        alpha[before - 'a']++;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if(alpha[i] > 1) {
                sb.append((char) (i + 'a'));
            }
        }
        if(sb.length() == 0) sb.append("N");
        
        return sb.toString();
    }
}