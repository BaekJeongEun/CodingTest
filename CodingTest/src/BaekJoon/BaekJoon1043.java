package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon1043 { // 거짓말 (G4)

	static int n,m;
    static int ans = 0;
    static boolean know[];
    static ArrayList<Integer>party[];
    static ArrayList<Integer>people[];
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        know = new boolean[n+1];
        people = new ArrayList[n+1];
        party = new ArrayList[m];
        for(int i=1; i<=n; i++) {
            people[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++) {
            party[i] = new ArrayList<>();
        }
        
        t = br.readLine().split(" ");
        
        for(int i=1; i<t.length; i++) {
            know[Integer.parseInt(t[i])] = true;    // 이 사람들은 진실을 알고있다
        }
        
        
        for(int i=0; i<m; i++) {
            t = br.readLine().split(" ");
            for(int j=1; j<t.length; j++) {
                int tmp = Integer.parseInt(t[j]);
                party[i].add(tmp);      
                people[tmp].add(i);
            }
        }
        bfs();
    }
    public static void bfs() {
        Queue<Integer> q= new LinkedList<>();
        boolean visited [] = new boolean [m];
        
        for(int i=1; i<=n; i++) {
            if(know[i]) {   // 아는 사람들이 참여한 파티정보 
                for(int k=0; k<people[i].size(); k++) {
                    if(!visited[people[i].get(k)]) {
                        q.add(people[i].get(k));
                        visited[people[i].get(k)] = true;
                    }
                }
            }
        }
        
        
        while(!q.isEmpty()) {
            int a = q.poll();   // 파티번호
            
            
            for(int num : party[a]) {
                // num 이 참석한 파티정보
                for(int partyInfo : people[num]) {
                    if(!visited[partyInfo]) {
                        q.add(partyInfo);
                        visited[partyInfo] = true;
                    }
                }
            }
            
        }
        for(int i=0; i<m; i++) {
            if(!visited[i]) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
