package JAVA.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author      |   ysyoo
 * @platform    |   Baekjoon
 * @index       |   16194
 * @title       |   카드 구매 하기 2
 * @link        |   https://www.acmicpc.net/problem/16194
 * @level       |   Silver 1
 * @approach    |   DP - Bottom up
 * @algorithm   |   DP
 * @technique   |
 */
public class BOJ_s1_16194_카드구매하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] price = new int[n+1];
        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
            dp[i] = price[i];
        }

        // solve - DP bottom up
        for (int amount = 2; amount<=n; amount++) {
            for (int i=amount; i>0; i--) {
                dp[amount] = Math.min(dp[amount], dp[amount-i] + price[i]);
            }
        }

        // output
        System.out.println(dp[n]);
    }
}
