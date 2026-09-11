package JAVA.DP;

/**
 * [BOJ] 1463. 1로만들기 (S3)
 * @category DP
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-04
 */

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S3_1463_1로만들기 {
	public static int X;
	public static int[] dp; // n을 만드는데 드는 횟수 저장 (memoizaion)

	// n을 1로 만드는 데 드는 횟수
	public static int f(int n) {
		// 값이 아직 할당 안됐다면
		if (dp[n]==-1) {
			int min = Integer.MAX_VALUE;

			// n/3과 n/2와 n-1의 횟수 중 최소 값을 채택++;
			if (n%3==0) min = f(n/3)<min?f(n/3):min;	// 3으로 나누어 떨어질 때만
			if (n%2==0) min = f(n/2)<min?f(n/2):min;	// 2로 나누어 떨어질 때만
			min = f(n-1)<min?f(n-1):min;				// -1과 최소값 비교
			dp[n] = min+1;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		X = Integer.parseInt(sc.nextLine());
		dp = new int[X+1];
		Arrays.fill(dp, -1);
		dp[1] = 0;
		// output
		System.out.println(f(X));
	}
}
