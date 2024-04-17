package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BaekJoon7785 { // 회사에 있는 사람(S5)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> workArray = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String key = st.nextToken();
            String value = st.nextToken(); 

            if(value.equals("enter")){
                workArray.add(key);
            }else if(value.equals("leave")){ 
                workArray.remove(key);
            }
        }

        ArrayList<String> list = new ArrayList<String>(workArray);
        Collections.sort(list);

        for(int i = list.size()-1;  i >= 0; i--){ 
            bw.write(list.get(i) + "\n");
        }

        bw.flush();
        bw.close();
	}

}
