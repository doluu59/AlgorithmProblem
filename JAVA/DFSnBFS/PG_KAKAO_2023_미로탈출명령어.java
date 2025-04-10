package JAVA.DFSnBFS;

/**
 * @from 프로그래머스
 * @index 2023 KAKAO Blind Recruitment
 * @title 미로 탈출 명령어
 * @grade Level 3
 * @classification DFS, Greedy
 * @solve DFS를 하되, Greedy한 탐색 활용 (목표 깊이와 좌표에 도달했으면 이후 탐색은 안하도록)
 */
public class PG_KAKAO_2023_미로탈출명령어 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        static int K, N, M;
        static String answer;
        static int ti, tj;  // 타겟 좌표
        // 사전 순서대로 d l r u 순으로 탐색하기 위한 순서
        static final int[][] delta = { {1, 0}, {0, -1}, {0, 1}, {-1, 0} };
        static final char[] ds = { 'd', 'l', 'r', 'u' };


        public String solution(int n, int m, int y, int x, int r, int c, int k) {
            K = k; N = n; M = m;
            ti = r-1; tj = c-1;             // 목표 좌표
            int ci = y-1; int cj = x-1;     // 현재 좌표
            answer = "";


            int manDist = getManhattanDist(y-1, x-1);   // 출발~도착 좌표의 맨하탄 거리
            if (manDist%2 != K%2) return "impossible";  // 맨타한 거리와 목표 이동 거리의 홀짝이 다르면 불가능
            if (manDist > K) return "impossible";       // 최단 거리보다 목표가 짧아도 불가능

            dfs(y-1, x-1, "");

            if (answer.equals("")) answer = "impossible";
            return answer;
        }

        // dfs를 하는 대신 사전 순으로 해서 정답을 하나라도 찾으면 즉시 종료
        public void dfs(int i, int j, String path) {
            int dist = path.length();
            int manDist = getManhattanDist(i,j);

            if (dist == K) {
                if (i==ti && j==tj) {   // 목표 지점 도착
                    answer = path;
                    return;
                } else {                // 다른 곳 도착 (실패)
                    return;
                }
            }

            // 남은 이동 횟수보다 현재 좌표에서 목표까지 최단 거리가 길면 실패한 경로
            if (manDist > K-dist) return;

            // dfs, 사전 순서대로 탐색
            for (int d=0; d<4; d++) {
                int ni = i+delta[d][0];
                int nj = j+delta[d][1];

                if (!isValid(ni, nj)) continue;

                dfs(ni, nj, path+ds[d]);

                // 사전 순서대로 탐색 중이기 때문에 경로 구했으면 그게 정답.
                if (!answer.equals("")) return;
            }
        }

        // 목표 지점까지의 맨하탄 거리 (최단 거리)
        public int getManhattanDist(int i, int j) {
            return Math.abs(ti-i) + Math.abs(tj-j);
        }

        // 미로 범위에 유효한 좌표인지
        public boolean isValid(int i, int j) {
            return (i>=0 && i<N && j>=0 && j<M);
        }
    }
}

