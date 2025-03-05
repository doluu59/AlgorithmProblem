package JAVA.DFSnBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @from Backjoon
 * @index 11724
 * @title 연결 요소의 개수
 * @grade Silver 2
 * @classification DFS, Union Find
 * @solve 인접한 노드를 리스트로 만들고, dfs를 통해 연결된 애들은 방문처리
 */
public class BOJ_s2_11724_연결요소의개수 {
    static int N, M;
    static boolean[] isVisited;
    public static List<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        for (int i=0; i<N; i++) {
            adjList[i] = new ArrayList<>();
        }
        // add adjList
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken())-1;
            int n2 = Integer.parseInt(st.nextToken())-1;

            adjList[n1].add(n2);
            adjList[n2].add(n1);
        }

        isVisited = new boolean[N];
        int ccNum = 0;  // number of Connected Component
        for (int i=0; i<N; i++) {
            // if not visited
            if (!isVisited[i]) {
                dfs(i);
                ccNum++;
            }
        }

        // output
        System.out.println(ccNum);
    }

    public static void dfs(int node) {
        // already visited node
        if (isVisited[node]) {
            return;
        }

        // check visit
        isVisited[node] = true;

        // not visited node
        for (int i=0; i<adjList[node].size(); i++) {
            dfs(adjList[node].get(i));  // 인접한 노드 방문
        }
    }
}
