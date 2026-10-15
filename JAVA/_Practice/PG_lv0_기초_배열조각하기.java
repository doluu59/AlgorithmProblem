package JAVA._Practice;

/**
 * [PG] 기초. 배열조각하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 15.
 */

import java.util.*;
public class PG_lv0_기초_배열조각하기 {
	public static void main(String[] args){
	}
	static class Solution {
		public int[] solution(int[] arr, int[] query) {
			List<Integer> list = new ArrayList<>();
			for (int i : arr) {
				list.add(i);
			}
			for (int i = 0; i < query.length; i++) {
				if (i % 2 == 0) {
					list = list.subList(0, query[i] + 1);
				} else {
					list = list.subList(query[i], list.size());
				}
			}
			int[] answer = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;
		}
	}
}
