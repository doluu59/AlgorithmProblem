package JAVA._Practice;

/**
 * [PG] 둘만의암호 | 연습 · Lv.1
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
 
public class PG_lv1_연습_둘만의암호 {
	class Solution {
		public String solution(String s, String skip, int index) {
			StringBuilder sb = new StringBuilder();

			for (char ch : s.toCharArray()) {
				int count = 0;

				while (count < index) {
					if (ch == 'z') {
						ch = 'a';
					} else {
						ch++;
					}

					if (!skip.contains(String.valueOf(ch))) {
						count++;
					}
				}
				sb.append(ch);
			}
			return sb.toString();
		}
	}
}
