package JAVA.DFSnBFS;

import java.util.*;

/**
 * @from Programmers
 * @index 2025 코드 챌린지 1차 예선
 * @title 지게차와 크레인
 * @grade Level 2
 * @classification BFS
 * @solve 가장 자리를 찾는 BFS
 */
public class PG_CodeChallenge_2025_지게차와크레인 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        static int n, m;
        static int[][] map;
        static final int[][] delta = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        public int solution(String[] storage, String[] requests) {
            n = storage.length;
            m = storage[1].length();
            int answer = 0;

            // input
            map = new int[n][m];
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    map[i][j] = storage[i].charAt(j) - 'A';
                }
            }

            // 출고 요청 처리
            for (String request : requests) {
                getContainer(request.charAt(0)-'A', request.length());
            }

            // output
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if(map[i][j] >= 0) answer++;
                }
            }
            return answer;
        }

        // 컨테이너 꺼내기
        public void getContainer(int containerIdx, int type) {
            // 접근 가능한 컨테이너를 모아둔 뒤에 한 번에 꺼내야 함
            Queue<Pos> containerQueue = new ArrayDeque<>();
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (map[i][j] == containerIdx) {
                        // 지게차면, 외부와 연결된 컨테이너만 접근 가능
                        if (type == 1 && !isConnected(i,j)) continue;

                        containerQueue.offer(new Pos(i, j));
                    }
                }
            }

            // 접근 가능한 컨테이너만 꺼내기
            while(!containerQueue.isEmpty()) {
                Pos cur = containerQueue.poll();
                map[cur.y][cur.x] = -1;
            }
        }

        // 외부와 연결 되어있는지
        public boolean isConnected(int i, int j) {
            // bfs
            // 컨테이너가 빠진 빈 곳을 탐색 -> 경계랑 닿으면 외부와 연결
            boolean[][] isVisited = new boolean[n][m];
            Queue<Pos> queue = new ArrayDeque<>();
            queue.offer(new Pos(i, j));
            isVisited[i][j] = true;

            while (!queue.isEmpty()) {
                Pos cur = queue.poll();

                for (int d=0; d<4; d++) {
                    int ni = cur.y+delta[d][0];
                    int nj = cur.x+delta[d][1];

                    // 맵 벗어나면 외부와 연결 된 것
                    if (!isValid(ni, nj)) return true;

                    if (map[ni][nj] == -1 && !isVisited[ni][nj]) {
                        queue.offer(new Pos(ni, nj));
                        isVisited[cur.y][cur.x] = true;
                    }
                }
            }

            return false;
        }

        // 맵 벗어났는지
        public boolean isValid(int i, int j) {
            return (i >=0 && i<n && j >= 0 && j<m);
        }

        public static class Pos {
            int x, y;
            private Pos(int y, int x) {
                this.x = x;
                this.y = y;
            }
        }
    }


}
