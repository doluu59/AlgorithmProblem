package JAVA._Practice;

/**
 * [PG] 과일장수 | 연습 · Lv.1
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

import java.util.Arrays;

public class PG_lv1_연습_과일장수 {

	class Solution {
		public int solution(int k, int m, int[] score) {
			int answer = 0;
			Arrays.sort(score);

			for (int i = score.length; i >= m; i -= m) {
				answer += (score[i - m] * m);
			}

			return answer;
		}
	}
}
