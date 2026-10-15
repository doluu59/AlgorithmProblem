package JAVA._Practice;

/**
 * [PG] 입문. 배열회전시키기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : Deque
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 5.
 */

import java.util.*;

public class PG_lv0_입문_배열회전시키기 {
	class Solution {
		public int[] solution(int[] numbers, String direction) {
			Deque<Integer> deque = new ArrayDeque<>();
			for (int num : numbers) {
				deque.offerLast(num);
			}

			if (direction.equals("right")) {
				deque.offerFirst(deque.pollLast());
			} else {
				deque.offerLast(deque.pollFirst());
			}

			int[] answer = new int[numbers.length];
			for (int i=0; i<numbers.length; i++) {
				answer[i] = deque.pollFirst();
			}

			return answer;
		}
	}
}
