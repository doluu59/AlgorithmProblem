package JAVA._Practice;

/**
 * [PG] 햄버거만들기 | 연습 · Lv.1
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

import java.util.*;

public class PG_lv1_연습_햄버거만들기 {
	class Solution {
		public int solution(int[] ingredient) {
			int answer = 0;
			StringBuilder sb = new StringBuilder();
			int len = 0;
			for(int i : ingredient) {
				sb.append(i); len++;
				if(i == 1 && len >= 4 && sb.substring(len - 4).equals("1231")) {
					sb.delete(len - 4, len);
					len -= 4;
					answer++;
				}
			}
			return answer;
		}
	}
}
