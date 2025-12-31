package JAVA.DFSnBFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @from BOJ
 * @index 14940
 * @title 쉬운최단거리
 * @grade Silver 1
 * @classification BFS
 * @solve 시작 지점부터 BFS
 */
public class BOJ_s1_14940_쉬운최단거리 {
    public static int[][] delta = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    public static int[][] ans, map;
    public static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        ans = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solve
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 2) {
                    bfs(i, j);
                }
            }
        }

        // 원래 갈 수 있는 땅 중 도달 할 수 없는 곳은 -1
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 1 && ans[i][j]==0) {
                    ans[i][j] = -1;
                }
            }
        }

        // output
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                bw.write(ans[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs (int y, int x) {
        // 방문 체크는 ans == 0 인걸로
        // 벽 만난 거는 map == 0

        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(y, x, 0));

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for (int d=0; d<4; d++) {
                int ni = cur.y+delta[d][0];
                int nj = cur.x+delta[d][1];
                // 맵 벗어나면 패스
                if (!isValid(ni, nj)) continue;
                // 갈 수 없는 곳은 패스
                if (map[ni][nj] != 1) continue;
                // 방문해서 거리 측정이 된 좌표는 패스
                if (ans[ni][nj] != 0) continue;

                queue.offer(new Pos(ni, nj, cur.distance+1));
                ans[ni][nj] = cur.distance + 1;
            }
        }
    }

    public static boolean isValid(int y, int x) {
        return (y >= 0 && y<N && x>=0 && x<M);
    }

    public static class Pos {
        int x, y;
        int distance;

        public Pos(int i, int j, int distance) {
            this.y = i;
            this.x = j;
            this.distance = distance;
        }
    }
}
