package JAVA._Practice;

/**
 * [PG] 기초. 배열만들기5 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 11.
 */

import java.util.*;

public class PG_lv0_기초_배열만들기5 {
	public static void main(String[] args){
	}

	class Solution {
		public int[] solution(String[] intStrs, int k, int s, int l) {
			List<Integer> list = new ArrayList<>();
			for (String intStr : intStrs) {
				int num = Integer.parseInt(intStr.substring(s, s+l));
				if (num > k) list.add(num);
			}

			int[] answer = new int[list.size()];
			for (int i=0; i<list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;
		}
	}
}
