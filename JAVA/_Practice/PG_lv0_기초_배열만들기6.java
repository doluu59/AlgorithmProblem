package JAVA._Practice;

/**
 * [PG] 기초. 배열만들기6 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 21.
 */

import java.util.*;

public class PG_lv0_기초_배열만들기6 {
	public static void main(String[] args){
	}

	class Solution {
		public int[] solution(int[] arr) {
			List<Integer> list = new ArrayList<>();
			for (int i=0; i<arr.length; i++) {
				if (list.isEmpty()) {
					list.add(arr[i]);
				} else {
					if (list.get(list.size()-1) == arr[i]) {
						list.remove(list.size()-1);
					} else {
						list.add(arr[i]);
					}
				}
			}
			if (list.isEmpty()) list.add(-1);

			// list to arr
			int[] answer = new int[list.size()];
			for (int i=0; i<list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;
		}
	}
}
