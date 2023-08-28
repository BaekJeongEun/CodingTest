package BaekJoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon1417 { // 국회의원 선거 (S1)

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int temp = sc.nextInt();

        for (int i = 1; i < N ; i++) {
            queue.add(sc.nextInt());
        }
        int count = 0;

            while (!queue.isEmpty()){
                int num = queue.poll();
                if(temp <= num ){
                    count++;
                    temp++;
                    queue.add(--num);
                }
            }

        System.out.println(count);
    }
}
