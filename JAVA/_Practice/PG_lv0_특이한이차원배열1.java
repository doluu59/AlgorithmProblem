package JAVA._Practice;

public class PG_lv0_특이한이차원배열1 {
    public static void main(String[] args) {
        class Solution {
            public int[][] solution(int n) {
                int[][] answer = new int[n][n];

                for (int i=0; i<n; i++) {
                    for (int j=0; j<n; j++) {
                        if (i==j) answer[i][j] = 1;
                    }
                }
                return answer;
            }
        }
    }
}
