package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaekJoon1764 { // 듣보잡(S4)

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        String name ="";
        for(int i=0; i<N+M; i++) {
            name = br.readLine();
            map.put(name, map.getOrDefault(name, 0)+1);
        }
        int cnt = 0;
        for(String s : map.keySet()) {
            if(map.get(s) > 1) {
                cnt++;
                list.add(s);
            }
        }
        Collections.sort(list);
        System.out.println(cnt);
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}