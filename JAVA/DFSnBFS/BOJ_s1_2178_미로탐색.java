package JAVA.DFSnBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @from BaekJoon
 * @index 2178
 * @title 미로 탐색
 * @grade Silver 1
 * @classification DFS, BFS, 2-d fully search
 * @solve
 */
public class BOJ_s1_2178_미로탐색 {
    private static int n, m;
    private static int[][] map;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // input
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i=0; i<n; i++) {
            String[] str = br.readLine().split("");
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        isVisited = new boolean[n][m];

        // bfs
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int i, int j) {
        int[][] delta = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(j, i, 1));

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            // finish
            if (cur.x == m-1 && cur.y == n-1) {
                return cur.dist;
            }

            // 이미 방문 했던 곳이면 더 짧은 이동 횟수로 왔었기에 방문 중단 (BFS라서)
            if (isVisited[cur.y][cur.x]) continue;
            isVisited[cur.y][cur.x] = true;

            // move
            for (int d=0; d<4; d++) {
                int ni, nj;
                ni = cur.y + delta[d][0];
                nj = cur.x + delta[d][1];

                // map 벗어나면 안됨
                if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;

                if(map[ni][nj] == 1) {
                    queue.offer(new Pos(nj, ni, cur.dist+1));
                }
            }
        }
        return -1;
    }

    private static class Pos {
        private int x, y, dist;

        public Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
