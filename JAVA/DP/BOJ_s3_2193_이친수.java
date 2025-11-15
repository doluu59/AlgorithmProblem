package JAVA.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author      |   ysyoo
 * @platform    |   Baekjoon
 * @index       |   2193
 * @title       |   이친수
 * @link        |   https://www.acmicpc.net/problem/2193
 * @level       |   Silver 3
 * @approach    |   DP - Bottom up
 * @algorithm   |   DP
 * @technique   |   2-d array, long type
 */
public class BOJ_s3_2193_이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 1 ~ 90
        long answer = 0;

        // solve
        long[][] dp = new long[N+1][2];     // 1~n번째 자리의 숫자가 0 or 1인 이진수 개수
        dp[1][1] = 1;   // 첫째 자리는 무조건 1로 시작
        //  2. 1 다음은 무조건 0
        for (int i=2; i<=N; i++) {
            dp[i][1] = dp[i-1][0];              //  i번쨰 자리수가 1이면 그 앞에 수는 0인 것만 가능
            dp[i][0] = dp[i-1][0] + dp[i-1][1]; //  i번째 자리수가 0이면, 그 앞자리는 0, 1 둘 다 가능
        }

        answer = dp[N][1] + dp[N][0];
        System.out.println(answer);
    }
}
