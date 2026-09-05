package JAVA.DP;

/**
 * [BOJ] 2225. 합분해 (G5)
 * @category DP / Mathematics
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-06
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_2225_합분해 {
	static final int BIGNUM = 1_000_000_000;
	static long[][] memo;	//Memoization
	static int N, K;
	static long dp(int k, int n) {
		if (memo[k][n] == 0) {		//아직 계산 안됐으면 계산
			/*
			 * dp[k][n] = dp[k-1][0] + dp[k-1][1] + ... + dp[k-1][n] ;
			 *
			 * k개의 수를 이용해 n 만드는 경우의 수
			 *  = k-1 개 사용하여 0~n까지 만든 경우의 수의 총합
			 *  => k번째 수로 n-i를 사용하면 k개의 수를 사용하여 n을 만들 수 있다.
			 */
//			for (int i=0; i<=n; i++) {
//				memo[k][n] += dp(k-1, i);
//			}
			/*
			 *
			 * dp[k][n] = dp[k][n-1] + dp[k-1][n];
			 * ( dp[k][n-1] = dp[k-1][0] + dp[k-1][1] + ... + dp[k-1][n-1] 이므로 )
			 * k개 사용 n 만드는 경우의 수
			 * =
			 * k개 사용하여 0~n-1까지 만든 경우의 수의 합
			 * +
			 * k-1개 사용하여 n을 만든 경우의 수의 합
			 */
			memo[k][n] = (dp(k, n-1) + dp(k-1, n)) % BIGNUM;
		}
		// 이미 다른 데에서 구해진 값이면 그대로 저장해둔 memo 반환
		return memo[k][n];
	}
	public static void main(String[] args) throws IOException {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		memo = new long[K+1][N+1];
		// 1개의 수를 이용하여 총합 n만들기
		for (int n=0; n<=N; n++) {
			memo[1][n] = 1;
		}
		// k개의 수를 이용하여 총합 0 만들기
		for (int k=1; k<=K; k++) {
			memo[k][0] = 1;
		}
		// output - K개 숫자 사용하여 총합 N 만들기
		System.out.println(dp(K, N));
	}
}
