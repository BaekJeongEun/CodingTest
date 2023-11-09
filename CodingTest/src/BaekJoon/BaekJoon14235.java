package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BaekJoon14235 { // 크리스마스 선물(S3)
	static final int EMPTY = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = stoi.apply(st.nextToken());
            if(cnt == 0){
                if(!pq.isEmpty()){
                    System.out.println(pq.poll());
                }else{
                    System.out.println(EMPTY);
                }
                continue;
            }
            for(int j = 0 ; j < cnt ; j++){
                pq.offer(stoi.apply(st.nextToken()));
            }
        }
    }

}
