package JAVA.StackQueue.PriorityQueue;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @from BOJ
 * @index 11286
 * @title 절댓값 힙
 * @grade Silver 1
 * @classification 우선 순위 큐
 * @solve 우선 순위 큐. ***Comparator 재정의.
 */
public class BOJ_s1_11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int N = Integer.parseInt(br.readLine());

        // 우선 순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) != Math.abs(o2)) {
                    // 절댓값이 작은 게 우선
                    return Math.abs(o1) - Math.abs(o2);
                } else {
                    // 절댓값이 같으면 음수가 우선 순위
                    return o1 < o2 ? -1 : 1;
                }
            }
        });
        // 연산
        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                pq.add(x);
            } else {
                if (pq.isEmpty()) {
                    bw.write(0+"\n");
                } else {
                    bw.write(pq.poll()+"\n");
                }
            }
        }

        // output
        bw.flush();
        bw.close();
    }

}
