package JAVA._Practice;

/**
 * [PG] 귤고르기 | 연습 · Lv.2
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
public class PG_lv2_연습_귤고르기 {

	class Solution {
		public int solution(int k, int[] tangerine) {
			int answer = 0;
			int temp = 0;

			Map<Integer, Integer> map = new HashMap<>();

			for(int i = 0 ; i < tangerine.length; i++) {
				map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
			}

			List<Integer> list = new ArrayList<>(map.values());
			Collections.sort(list, Collections.reverseOrder());

			for(int i : list) {
				temp += i;
				answer++;

				if(temp >= k) break;
			}

			return answer;
		}
	}
}
