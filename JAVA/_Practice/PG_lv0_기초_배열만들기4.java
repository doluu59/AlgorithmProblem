package JAVA._Practice;

/**
 * [PG] 기초. 배열만들기4 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 23.
 */

import java.util.*;

public class PG_lv0_기초_배열만들기4 {
	class Solution {
		public int[] solution(int[] arr) {
			List<Integer> list = new ArrayList<>();

			int i=0;
			while (i<arr.length) {
				if (list.isEmpty()) {
					list.add(arr[i]);
					i++;
				} else {
					if (list.get(list.size()-1) < arr[i]) {
						list.add(arr[i]);
						i++;
					} else {
						list.remove(list.size()-1);
					}
				}
			}
			if (list.isEmpty()) list.add(-1);

			// list to arr
			int[] answer = new int[list.size()];
			for (int j=0; j<list.size(); j++) {
				answer[j] = list.get(j);
			}
			return answer;
		}
	}
}
