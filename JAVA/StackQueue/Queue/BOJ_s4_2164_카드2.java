package JAVA.StackQueue.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @from BOJ
 * @index 2164
 * @title 카드2
 * @grade Silver 4
 * @classification 큐
 * @solve 큐 기본
 */
public class BOJ_s4_2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            queue.offer(i);
        }

        // solve
        // 한번씩 번갈아가면서 행동 수행
        boolean flag = true;
        while (queue.size() > 1) {
            if (flag) {
                queue.remove();
                flag = false;
            } else {
                queue.offer(queue.poll());
                flag = true;
            }
        }

        // output
        System.out.println(queue.poll());
    }
}
