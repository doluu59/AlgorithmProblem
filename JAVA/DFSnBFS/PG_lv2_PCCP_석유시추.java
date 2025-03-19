package JAVA.DFSnBFS;
import java.util.*;
/**
 * @from Programmers
 * @index PCCP 기출 문제 2번
 * @title 석유 시추
 * @grade Level 2
 * @classification DFS/BFS
 * @solve BFS 혹은 DFS를 통해 같이 연결된 애들을 같은 index로 마킹, index와 depth를 map으로 저장
 *        각 열이 지나는 석유 index를 Set으로 모음(중복 X)
 *        해당 석유의 양 합해서 최대값 구하기
 */
public class PG_lv2_PCCP_석유시추 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public int[][] delta = { {0, -1}, {-1, 0}, {0, 1}, {1, 0} };
        public int n, m;
        public int[][] map;
        public HashMap<Integer, Integer> oils;

        public int solution(int[][] land) {
            int answer = 0;
            n = land.length;
            m = land[0].length;
            int oilIndex = 2;
            oils = new HashMap<>();

            // 석유 뭉텅이를 index, amount로 저장
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    // 아직 탐색 안한 석유만 탐색
                    if (land[i][j] == 1) {
                        // 석유 뭉텅이의 번호와 크기를 저장
                        oils.put(oilIndex, bfs(i, j, land, oilIndex++));
                    }
                }
            }

            // 각 열에서 석유 추출시 뽑는 index 구해서 더하기 최대값
            int max = Integer.MIN_VALUE;
            for (int j=0; j<m; j++) {
                HashSet<Integer> oilIndexSet = new HashSet<>();
                // 이번 열에 뽑을 수 있는 석유 번호
                for (int i=0; i<n; i++) {
                    if (land[i][j] != 0) {
                        oilIndexSet.add(land[i][j]);
                    }
                }
                if (oilIndexSet.size() == 0) continue;
                // 석유 뽑은양 합치기
                int sum = 0;
                for (Integer oil : oilIndexSet) {
                    sum += oils.get(oil);
                }
                if (sum > max) max = sum;
            }
            answer = max;
            return answer;
        }

        public int bfs(int i, int j, int[][] land, int oilIndex) {
            // init
            int depth = 0;
            Queue<Pos> queue = new ArrayDeque<>();

            //bfs
            land[i][j] = oilIndex;    // 방문 처리이자, 석유 뭉텅이 번호
            queue.offer(new Pos(j, i));

            while (!queue.isEmpty()) {
                Pos cur = queue.poll();
                depth++;
                for (int d=0; d<4; d++) {
                    int nj = cur.x + delta[d][0];
                    int ni = cur.y + delta[d][1];
                    if (isValid(ni, nj)) {
                        if (land[ni][nj] == 1) {
                            land[ni][nj] = oilIndex;
                            queue.offer(new Pos(nj, ni));
                        }
                    }
                }
            }
            return depth;
        }
        // map 범위 validation
        public boolean isValid(int i, int j) {
            if (j >= 0 && j < m && i >= 0 && i < n) return true;
            else return false;
        }

        public class Pos {
            int x, y;

            private Pos (int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }



}
