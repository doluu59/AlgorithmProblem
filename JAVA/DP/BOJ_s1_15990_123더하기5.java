package JAVA.DP;

import java.io.*;


/**
 * @author      |   ysyoo
 * @platform    |   Baekjoon
 * @index       |   15990
 * @title       |   1, 2, 3 더하기 5
 * @link        |   https://www.acmicpc.net/problem/15990
 * @level       |   Silver 1
 * @approach    |   2-d DP
 * @algorithm   |   DP
 * @technique   |   2-d Array
 */
public class BOJ_s1_15990_123더하기5 {
    static final int MOD = 1000000009;
    static long[][] dp = new long[100001][4];    // i를 만들 수 있는 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        for (int i = 4; i<= 100_000; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;   // 끝이 1인 조합
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
        }

        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());

            long answer = 0;
            for (int i=1; i<=3; i++) {
                answer += dp[n][i];
            }
            answer %= MOD;

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }
}
