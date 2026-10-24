package JAVA.StackQueue.Queue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_S4_1158_요세푸스문제 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        //input
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i=1; i<=N; i++) {
            queue.offerLast(i);
        }
        //구현부 맨 위 빼기, 그 다음 맨위를 맨 아래로 이동, 사이즈 1되면 반복 중지
        for( ; queue.size()>1 ; ) {
            queue.pollFirst();
            queue.offerLast(queue.pollFirst());
        }
        //output
        bw.write(Integer.toString(queue.pollFirst()));
        //close
        bw.flush(); bw.close(); br.close();
    }
}
