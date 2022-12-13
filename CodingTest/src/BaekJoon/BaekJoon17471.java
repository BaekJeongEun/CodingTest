package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon17471 { // 게리맨더링 (G4)
    static int N, min = Integer.MAX_VALUE;
    static ArrayList<Integer> ad[];
    static int[] population;
    static boolean[] visit;
    static ArrayList<Integer> pick = new ArrayList<>();
    static ArrayList<Integer> unPick = new ArrayList<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ad = new ArrayList[N+1];
        population = new int[N+1];
        visit = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            ad[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for(int j=1; j<=n; j++) {
                int node = Integer.parseInt(st.nextToken());
                ad[i].add(node);
                ad[node].add(i);
            }
        }
        subset(0);
        System.out.println((min == Integer.MAX_VALUE)?-1:min);
    }

    private static void subset(int idx) {
        if(idx == N) { // 부분집합 다 만들었다
            pick = new ArrayList<>();
            unPick = new ArrayList<>();
            for(int v=1; v<=N; v++) {
                if(visit[v]) { // 뽑힌 것
                    pick.add(v);
                }else { // 안 뽑힌 것
                    unPick.add(v);
                }
            }
            if(pick.size() == 0 || unPick.size() == 0) return; // 두 구역으로 못 나눈다면
            int pickSuc = bfs(pick);
            if(pickSuc == -1) return; // -1 반환되면 모두 연결되어 있지 않다는 의미
            int unPickSuc = bfs(unPick);
            if(unPickSuc == -1) return; // -1 반환되면 모두 연결되어 있지 않다는 의미
            
            min = Math.min(min, Math.abs(pickSuc- unPickSuc));
            return;
        }
        
        visit[idx] = true;
        subset(idx + 1);
        visit[idx] = false;
        subset(idx + 1);
    }

    private static int bfs(ArrayList<Integer> list) {
        boolean[] visit = new boolean[N+1];
        Queue<Integer> copy = new ArrayDeque();
        copy.offer(list.get(0));
        visit[list.get(0)] = true;
        while(!copy.isEmpty()) {
            int now = copy.poll();
            for(int i=0; i<ad[now].size(); i++) {
                int idx = ad[now].get(i);
                if(!visit[idx] && list.contains(idx)) {
                    copy.offer(idx);
                    visit[idx] = true;
                }
            }
        }
        int sum = 0;
        int cnt = 0;
        for(int i=0; i<list.size(); i++) {
            if(visit[list.get(i)]) {
                sum += population[list.get(i)];
                cnt++;
            }
        }
        return (cnt==list.size())?sum:-1; // 한 번에 다 돌 수 없으면 -1 반환
    }

}