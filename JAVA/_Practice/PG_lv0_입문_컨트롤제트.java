package JAVA._Practice;

/**
 * [PG] 입문. 컨트롤제트 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : stack, StringTokenizer
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 25.
 */

import java.util.*;

public class PG_lv0_입문_컨트롤제트 {
	class Solution {
		public int solution(String s) {
			int answer = 0;
			Deque<Integer> stack = new ArrayDeque<>();

			StringTokenizer st = new StringTokenizer(s);
			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				if (str.equals("Z")) stack.pollLast();
				else stack.offerLast(Integer.parseInt(str));
			}

			while (!stack.isEmpty()) {
				answer += stack.pollLast();
			}
			return answer;
		}
	}
}
