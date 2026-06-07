package JAVA.DP;

/**
 * [BOJ] 1010. 다리놓기 (S5)
 * @category DP
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-07
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S5_1010_다리놓기 {
	static int N, M;
	static long[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new long[M+1][N+1];
			// mCn 구하기
			bw.write(Long.toString(comb(M,N))+"\n");
		}
		bw.flush(); bw.close(); br.close();
	}
	// 동쪽 다리 M개 중 N개를 고르는 조합으로 만들면 차례대로 다리가 지어져 겹치지 않음.
	public static long comb(int m, int n) {
		if (dp[m][n] == 0) {	// Memoization에 저장이 안된 값이라면 계산
			if (n==0 || n==m) dp[m][n] = 1;		//mC0 또는 mCm은 1.
			else dp[m][n] = comb(m-1, n-1) + comb(m-1, n);	// mCn = m-1Cn-1 + m-1Cn
		}
		return dp[m][n];
	}
}
