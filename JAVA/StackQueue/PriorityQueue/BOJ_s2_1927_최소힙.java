package JAVA.StackQueue.PriorityQueue;

import java.io.*;
import java.util.PriorityQueue;

/**
 * @from BOJ
 * @index 1927
 * @title 최소 힙
 * @grade Silver 2
 * @classification Priority Queue
 * @solve PQ 구현
 */

public class BOJ_s2_1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                pq.offer(num);
                continue;
            }

            if (pq.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(pq.poll());
            }
        }
    }
}
