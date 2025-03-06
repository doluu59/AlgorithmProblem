package JAVA.DFSnBFS;

import java.io.*;
import java.util.*;

/**
 * @from Baekjoon
 * @index 1260
 * @title DFS와 BFS
 * @grade Silver 2
 * @classification DFS, BFS
 * @solve dfs와 bfs 기본. dfs는 방문 처리를 방문한 후에 하기.
 */
public class BOJ_s2_1260_DFS와BFS {
    private static BufferedWriter bw;
    public static int n, m;
    public static List<Integer>[] adjNode;  // 각 노드에 인접한 행렬. 번호 작은 것부터 나가기 위함
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        adjNode = new ArrayList[n+1];
        for (int i=0; i<=n; i++) {
            adjNode[i] = new ArrayList<>();
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            adjNode[n1].add(n2);
            adjNode[n2].add(n1);
        }
        // adjNode sort
        for (int i=0; i<=n; i++) {
            Collections.sort(adjNode[i]);
        }

        isVisited = new boolean[n+1];

        // dfs
        dfs(v);
        bw.write("\n");

        // 방문한 노드 초기화
        Arrays.fill(isVisited, false);
//        for (boolean i: isVisited) {
//            i = false;
//        }

        // bfs
        bfs(v);

        // output
        bw.flush();
        bw.close();
    }

    private static void dfs(int node) throws IOException {
        isVisited[node] = true;
        bw.write(node+" ");

        for (int nextNode: adjNode[node]) {
            if (!isVisited[nextNode]) dfs(nextNode);
        }
    }

    private static void bfs(int v) throws IOException {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(v);

        while(!queue.isEmpty()) {
            int curNode = queue.poll();

            // 방문하지 않은 노드면 추가
            if (isVisited[curNode]) continue;
            else {
                isVisited[curNode] = true;
                bw.write(curNode+" ");
            }

            // 인접 노드들 추가
            for(int adjNode : adjNode[curNode]) {
                queue.offer(adjNode);
            }
        }
    }
}
