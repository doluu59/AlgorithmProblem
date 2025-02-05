package JAVA.SlidingWindow.BOJ;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @from BOJ
 * @index 11003
 * @title 최솟값 찾기
 * @grade Platinum 5
 * @classification Sliding Window
 * @solve Deque 자료구조와 Sliding Window 기법을 활용
 */
public class BOJ_p5_11003_최솟값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> slidingWindow = new ArrayDeque<>();
        for (int i=0; i<N; i++) {
            // 이번 노드
            Node curNode = new Node(i, Integer.parseInt(st.nextToken()));
            // 현재보다 value가 큰 노드는 제거
            while (!slidingWindow.isEmpty() &&
                    slidingWindow.getLast().value > curNode.value) {
                slidingWindow.removeLast();
            }
            slidingWindow.addLast(curNode);
            // 범위 벗어나면 제거
            if(slidingWindow.getFirst().index <= i-L) {
                slidingWindow.removeFirst();
            }
            //
            bw.write(slidingWindow.getFirst().value+" ");
        }
        // output
        bw.flush();
        bw.close();
    }

    public static class Node {
        int index;
        int value;
        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
