/**
 * @from Programmers
 * @index
 * @title 네트워크
 * @grade Level 3
 * @classification DFS
 */

package JAVA.DFSnBFS.Programmers.high_score_kit;

import java.util.*;

public class PG_lv3_네트워크 {
    static int N;
    static int[][] coms;
    static int answer=0;
    static boolean[] isVisited;
    public int solution(int n, int[][] computers) {
        N=n;
        coms = computers;
        isVisited = new boolean[N];

        for (int i=0; i<n; i++) {
            if (!isVisited[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }
    static void dfs(int cur) {
        isVisited[cur] = true;

        for (int i=0; i<N; i++) {
            if (coms[cur][i]==1 && !isVisited[i]) {
                dfs(i);
            }
        }
    }
}