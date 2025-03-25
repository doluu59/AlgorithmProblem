package JAVA.PrefixSum;

/**
 * @from Programmers
 * @index Kakao 2022 Blind Recruitment
 * @title 파괴 되지 않은 건물
 * @grade Level 3
 * @classification Prefix Sum
 * @solve 특정 구간에 같은 변화량을 Prefix Sum으로 구현 하여 시간 초과 줄이기
 */

public class PG_Kakao_2022_lv3_파괴되지않은건물 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        static int n, m;
        public int solution(int[][] board, int[][] skill) {
            n = board.length;
            m = board[0].length;

        /*
        // Brute Force
        for (int[] s: skill) {
            int damage = s[0]==1? -s[5] : s[5];
            for (int r=s[1]; r<=s[3]; r++) {
                for (int c=s[2]; c<=s[4]; c++) {
                    board[r][c] += damage;
                }
            }
        }
        */

            // 부분 합
            int[][] subsetSum = new int[n+1][m+1];
            for (int[] s: skill) {
                int damage = s[0]==1 ? -s[5] : s[5];

                subsetSum[s[1]][s[2]] += damage;
                subsetSum[s[1]][s[4]+1] -= damage;
                subsetSum[s[3]+1][s[2]] -= damage;
                subsetSum[s[3]+1][s[4]+1] += damage;
            }

            // 누적 합
            for (int j=0; j<m; j++) {
                for (int i=1; i<n+1; i++) {
                    subsetSum[i][j] = subsetSum[i-1][j] + subsetSum[i][j];
                }
            }
            for (int i=0; i<n; i++) {
                for (int j=1; j<m+1; j++) {
                    subsetSum[i][j] = subsetSum[i][j-1] + subsetSum[i][j];
                }
            }

            // result
            int answer = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    board[i][j] = board[i][j] + subsetSum[i][j];
                    if (board[i][j] >= 1) answer++;
                }
            }
            return answer;
        }
    }
}
