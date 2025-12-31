package JAVA.DFSnBFS;

import java.io.*;
import java.util.*;

/**
 * @from BOJ
 * @index 2667
 * @title 단지 번호 붙이기
 * @grade Silver 1
 * @classification DFS, UnionFind
 * @solve   1. 모든 점에서 출발하는 DFS or BFS 돌려서 시작할 떄마다 인덱스 바꾸든가
 *          2. Union Find로 하기
 */
public class BOJ_s1_2667_단지번호붙이기 {
    public static int[][] delta = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    public static int[][] map;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // input
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        PriorityQueue<Integer> answer = new PriorityQueue<>();  // 단지 당 아파트 수 (오름차 순 위해 PQ)

        for (int i=0; i<N; i++) {
            String[] str = br.readLine().split("");
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        // solve
        int index = -1;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 1) {
                    answer.add(bfs(i, j, index--));
                }
            }
        }

        // output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer.size()+"\n");   // 단지 수
        while(!answer.isEmpty()) {
            bw.write(answer.poll()+"\n");   // 단지 당 아파트 수
        }
        bw.flush();
        bw.close();
    }

    public static int bfs (int si, int sj, int index) {
        int aptCount = 1;  // 단지의 아파트 수

        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(si, sj));
        map[si][sj] = index; // 방문 체크 겸 같은 단지는 같은 인덱스로 묶기


        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            for (int d=0; d<4; d++) {
                int ni = cur.y + delta[d][0];
                int nj = cur.x + delta[d][1];

                // Map 벗어남
                if (!isValid(ni, nj)) continue;
                // 같은 단지 아파트가 아님
                if (map[ni][nj] != 1) continue;

                // 같은 단지 아파트
                queue.offer(new Pos(ni, nj));
                map[ni][nj] = index;
                aptCount++;
            }
        }

        return aptCount;
    }

    public static boolean isValid(int i, int j) {
        return (i>=0 && i<N && j>=0 && j<N);
    }

    static class Pos {
        private int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }


    }

}

