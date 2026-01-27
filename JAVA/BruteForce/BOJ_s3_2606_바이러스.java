package JAVA.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @from Baekjoon
 * @index 2606
 * @title 바이러스
 * @grade Silver 3
 * @classification BFS, DFS
 * @solve 연결 상태를 2차원 배열 or 리스트의 배열로 저장한 후 DFS나 BFS
 */

public class BOJ_s3_2606_바이러스 {
    static int N, E; // node 수, edge 수
    static boolean[] isVisited;
    static List<Integer>[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        isVisited = new boolean[N];

        // Input
        // 노드 간의 연결된 엣지 양방향으로 저장
        // 2차원 배열 or List의 배열
        node = new ArrayList[N];
        for (int i=0; i<N; i++) {
            node[i] = new ArrayList<Integer>();
        }
        StringTokenizer st;
        for (int i=0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken())-1;
            int node2 = Integer.parseInt(st.nextToken())-1;
            node[node1].add(node2);
            node[node2].add(node1);
        }

        // bfs
        int answer = bfs(0);
        System.out.println(answer);
    }

    static int bfs(int start) {
        int interruptedCount = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        isVisited[start] = true;

        while(!queue.isEmpty()) {
           int cur = queue.poll();

           for (int connectedNode : node[cur]) {
               // 이미 방문한 노드
               if (isVisited[connectedNode]) continue;

               queue.offer(connectedNode);
               isVisited[connectedNode] = true;
               interruptedCount++;
           }
        }

        return interruptedCount;
    }
}
