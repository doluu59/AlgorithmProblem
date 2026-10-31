package yoo.algorithm.JAVA.StackQueue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @from BOJ
 * @index 2075
 * @title N번째 큰 수
 * @grade Silver 3
 * @classification Priority Queue
 * @solve 그냥 우선순위 큐 기본
 */
public class BOJ_s3_2075_N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Long> pq = new PriorityQueue<Long>((Long o1, Long o2) -> {
            int a = (int) (o2 - o1);
            return a;
        });
        int N = Integer.parseInt(br.readLine());

        // input
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
        }

        // N-1번째 큰 수까지 다 빼냄
        for (int i=0; i<N-1; i++) {
            pq.poll();
        }

        System.out.println(pq.poll());
    }

}
