package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon1193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int x=0, y=0, floor=0, sum=0;
		while(true) {
			floor++;
			sum += floor;
			if(sum >= n) {
				if(n%2==0) {
					System.out.println(n-sum+floor+"/"+(sum-n+1));
				}else {
					System.out.println((sum-n+1)+"/"+(n-sum+floor));
				}
				break;
			}
		}
	}
}
/*

package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon1193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int x=0, y=0, direction=0; // 1 오른, 2 대각선 아래, 3아래, 4대각선 위
		for(int i=1; i<n; i++)
		{
			System.out.println(x+" , "+y);
			if(x==0 && y%2==0) { 
				y++;
				System.out.println("오른쪽");
				continue;
			}
			if(y==0 && x%2!=0) {
				x++;
				System.out.println("아래쪽");
				continue;
			}
			if(x==0 && y%2!=0) {
				direction = 2;
			} 
			else if(y==0 && x%2==0) {
				direction = 4;
			}
			if(direction == 2) {// 아래
				x++;
				y--;
				System.out.println("대각선 아래쪽");
				continue;
			}
			
			if(direction == 4) {// 아래
				x--;
				y++;
				System.out.println("대각선 위쪽");
			}
			
			System.out.println(x+" "+y);
		}
		System.out.println((x+1)+"/"+(y+1));
	}

}


 * 
 * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int cal(int i){
        return (i*(i-1))/2+1;

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        for (int i = 1; i <=x ; i++) {
            if(cal(i)<=x &&cal(i+1)>x){
                 if(i%2==0){
                    System.out.println((x-cal(i)+1)+"/"+(i-x+cal(i)));
                }else
                    System.out.println((i-x+cal(i))+"/"+(x-cal(i)+1));
                break;
            }
        }
    }
}

*/
