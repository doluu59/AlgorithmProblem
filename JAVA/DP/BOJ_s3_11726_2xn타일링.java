package JAVA.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @from Baekjoon (code.plus 코딩 테스트 준비 - 기초 - DP Part 1)
 * @index 11726
 * @title 2xn 타일링
 * @grade silver 3
 * @classification DP
 * @solve 점화식 구하기 (직접 1부터 만들어보는 게 가장 보기 쉬움)
 */
public class BOJ_s3_11726_2xn타일링 {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[1] = 1;
        if (n>1) dp[2] = 2;

        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10_007;
        }

        int answer = dp[n];
        System.out.println(answer);
    }
}
