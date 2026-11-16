package JAVA._Practice;

/**
 * [PG] 멀리뛰기 | 연습 · Lv.2
 *
 * @category 
 * @algorithm 
 *
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 * - 탐구 과정 (생략 가능)
 *
 * @author   ysyoo
 * @see      <a href="">Problem Link</a>
 */
 
public class PG_lv2_연습_멀리뛰기 {
	class Solution {
		public long solution(int n) {
			// 길이가 2001인 dp 배열 선언
			int[] dp = new int[2001];
			dp[1] = 1; // n이 1일 때 방법의 수
			dp[2] = 2; // n이 2일 때 방법의 수

			// i = 3부터 dp 길이까지 반복
			for (int i = 3; i < dp.length; i++) {
				// i - 2일 때 방법의 수 + i - 1일 때 방법의 수를 저장
				dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
			}

			return dp[n];
		}
	}
}
