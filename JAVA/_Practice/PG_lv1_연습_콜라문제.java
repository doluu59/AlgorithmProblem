package JAVA._Practice;

/**
 * [PG] 콜라문제 | 연습 · Lv.1
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
 
public class PG_lv1_연습_콜라문제 {
	static class Solution {
		public int solution(int a, int b, int n) {
			int answer = 0;

			while (n >= a) {
				answer += n / a * b;
				n = n % a + n / a * b;
			}

			return answer;
		}
	}
}
