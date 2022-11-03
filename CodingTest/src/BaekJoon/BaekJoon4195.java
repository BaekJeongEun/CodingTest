package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaekJoon4195 { // 친구 네트워크 (G2)
    static int F;
    static HashMap<String, String> map;
    static HashMap<String, Integer> count;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            map = new HashMap<>();
            count = new HashMap<>();
            F = Integer.parseInt(br.readLine());
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String first = st.nextToken();
                String second = st.nextToken();
                sb.append(union(first, second)+"\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static int union(String first, String second) {
        String firstP = find(first);
        String secondP = find(second);
        int firstCnt = count.getOrDefault(firstP, 1);
        int secondCnt = count.getOrDefault(secondP, 1);
        if (!firstP.equals(secondP)) { // 두 부모가 같지 않다면
            count.put(firstP, firstCnt + secondCnt);
            count.put(secondP, firstCnt + secondCnt);
        }else count.put(firstP, firstCnt);
        
        map.put(firstP, secondP);
        return count.get(find(first));
    }

    private static String find(String cur) {
        if (!map.containsKey(cur) || map.get(cur).equals(cur)) // 내 자신이 최상단
            return cur;
        return map.put(cur, find(map.get(cur))); // 현재 구하고자 하는 노드의 최상위 조상 찾기
    }
}