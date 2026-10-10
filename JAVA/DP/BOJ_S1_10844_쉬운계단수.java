package JAVA.DP;

/**
 * [BOJ] 10844. 쉬운계단수 (S1)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-04
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S1_10844_쉬운계단수 {
	static final int BIG_NUM = 1_000_000_000;
	static long[][] dp;		// dp[n][m] : 길이가 n인 문자열의 마지막 자리가 m인 경우의 수

	public static void main(String[] args) throws NumberFormatException, IOException {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		dp = new long[N+1][10];
		Arrays.fill(dp[1], 1);		// 한 자리 수일 땐 끝자리가 1~9인 경우의 수는 모두 1
		dp[1][0] = 0;
		// n자리 숫자의 끝자리가 i인 계단 수의 개수
		for (int n=2; n<=N; n++) {
			//  n-1자리 숫자의 끝자리가 i인 경우 n자리 수의 끝자리는 i+1, i-1
			for (int i=0; i<=9; i++) {
				if (i==0) {		//0과 9는 끝자리가 -1과 10이 될 수 없으므로 한쪽만 카운트
					dp[n][i+1] += dp[n-1][i] % BIG_NUM;
				} else if (i==9) {
					dp[n][i-1] += dp[n-1][i] % BIG_NUM;
				} else {
					dp[n][i-1] += dp[n-1][i] % BIG_NUM;
					dp[n][i+1] += dp[n-1][i] % BIG_NUM;
				}
			}
		}
		long cnt = 0;	// 길이간 N인 계단 수의 개수
		// 길이가 N인 계단 수 중 끝이 i인 계단 수의 개수 합치기
		for (int i=0; i<=9; i++) {
			cnt += dp[N][i];
		}
		cnt %= BIG_NUM;
		System.out.println(cnt);
	}
}
