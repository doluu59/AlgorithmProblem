package JAVA.DFSnBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @from BackJoon
 * @index 13023
 * @title ABCDE
 * @grade Gold 5
 * @classification 그래프 탐색 (DFS)
 * @solve 친구 관계를 인접 행렬로 저장. dfs의 깊이가 5를 달성하면 성공, 모두 5가 안되면 실패
 */
public class BOj_g5_13023_ABCDE {
    static int N, E;
    static List<Integer>[] adjList;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        for (int i=0; i<N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            adjList[n1].add(n2);
            adjList[n2].add(n1);
        }

        isVisited = new boolean[N];

        // solve
        int answer = 0;
        // dfs로 연결된 친구를 찾아서 5명이상 연결 되어 있으면 1, 하나도 없으면 0
        for (int i=0; i<N; i++) {
            if (dfs(i, 1)) {
                answer = 1;
                break;
            }
        }

        // output
        System.out.println(answer);
    }

    public static boolean dfs(int me, int n) {
        // 목표 달성 조건
        if (n == 5) {
            return true;
        }

        // check visited
        isVisited[me] = true;

        // 내 친구 찾기
        for (int i=0; i < adjList[me].size(); i++) {
            int friend = adjList[me].get(i);
            // 새로운 친구가 있으면
            if (!isVisited[friend]) {
                if (dfs(friend, n+1)) {     // 5명 연결 됐으면 종료
                    return true;
                }
            }
        }

        // 조건 달성 실패시 다시 visited 초기화
        isVisited[me] = false;
        return false;
    }
}
