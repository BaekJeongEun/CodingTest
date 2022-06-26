package BaekJoon;

import java.util.*;
import java.io.*;
 
 
class node implements Comparable<node>{ // 우선순위 큐를 사용하기 위함
    int end; // 도착점
    int cost; // 가중치
 
    public node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
 
    @Override
    public int compareTo(node o) {
        return this.cost-o.cost;
    }
}
 
 
public class _BaekJoon1753 {
 
    static int v;
    static int e;
    static List<node>[] list;
    static boolean [] check; //이미 들린 정점인지 확인하는 배열
    static int [] distance; // 각 정점의 값을 저장
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list= new ArrayList[v+1];
        check= new boolean[v+1];
 
        distance= new int[v+1];
 
        for(int i=1; i<=v; i++){
            distance[i]=Integer.MAX_VALUE;
            list[i]=new ArrayList<>();
        }
        int a,b,c;
        int start = Integer.parseInt(br.readLine());
 
        for(int i=0; i<e; i++){
            String[] s1 = br.readLine().split(" ");
            a=Integer.parseInt(s1[0]);
            b=Integer.parseInt(s1[1]);
            c=Integer.parseInt(s1[2]);
            list[a].add(new node(b,c)); // 시작점, 도착점, 가중치
        }
        dij(start);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=v; i++){
            if(distance[i]==Integer.MAX_VALUE){
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(distance[i]).append("\n");
        }
 
        System.out.println(sb.toString());
    }
 
 
    public static void dij(int start){
        distance[start]=0;
        PriorityQueue<node> queue = new PriorityQueue<>();
        queue.add(new node(start,0));
        while (!queue.isEmpty()){
            node poll = queue.poll();
            check[poll.end]=true;
            for (node now: list[poll.end]){
                if(!check[now.end]){
                    if(distance[poll.end]+now.cost<distance[now.end]){ // 다음 가중치 + 현재의 가중치 < 이미 저장된 가중치라면 바꿔주고 큐에 넣기 
                        distance[now.end]=distance[poll.end]+now.cost;
                        queue.add(new node(now.end, distance[now.end]));
                    }
                }
            }
        }
    }
}