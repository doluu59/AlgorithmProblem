package JAVA.DFSnBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @from Baekjoon
 * @index 1167
 * @title 트리의 지름
 * @grade Gold 2
 * @classification BFS
 * @solve 트리의 지름을 구하는 것의 아이디어가 매우 중요.
 *          트리의 지름으로 선정된 노드 2개는 임의의 노드에서 가장 먼 노드 1과 가장 먼 노드이다.
 *          BFS를 통해 임의의 노드에서의 각 노드 별 거리를 구함.
 *          그 중 가장 길이가 긴 노드에서 가장 먼 노드를 한번 더 BFS로 구함
 */
public class BOJ_g2_1167_트리의지름 {
    private static int N;
    private static List<Edge>[] adjNodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        N = Integer.parseInt(br.readLine());
        adjNodes = new ArrayList[N];
        for(int i=0; i<N; i++) {
            adjNodes[i] = new ArrayList<>();
        }

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken())-1;
            while (true) {
                int adjNode = Integer.parseInt(st.nextToken())-1;
                if (adjNode < 0) break;
                int dist = Integer.parseInt(st.nextToken());

                adjNodes[node].add(new Edge(adjNode, dist));
            }
        }

        // solve
        // 임의의 노드 0번에서 가장 먼 노드를 구함.
        Edge maxEdge = bfs(0);
        // 해당 노드에서 가장 먼 노드를 찾아 길이를 구함.
        Edge max = bfs(maxEdge.node);

        // output
        System.out.println(max.length);
    }

    private static Edge bfs(int start) {
        boolean[] isVisited = new boolean[N];
        int[] dist = new int[N];

        Queue<Edge> queue = new ArrayDeque<>();
        queue.offer(new Edge(start, 0));
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            Edge cur = queue.poll();

            for (Edge adjNode : adjNodes[cur.node]) {
                if (!isVisited[adjNode.node]) {
                    queue.offer(adjNode);
                    isVisited[adjNode.node] = true;
                    dist[adjNode.node] = dist[cur.node] + adjNode.length;
                }
            }
        }

        int maxNode = 0;
        for (int i=1; i<N; i++) {
            if (dist[maxNode] < dist[i]) maxNode = i;
        }

        return new Edge(maxNode, dist[maxNode]);
    }

    private static class Edge {
        private int node, length;

        public Edge(int node, int length) {
            this.node = node;
            this.length = length;
        }
    }
}
