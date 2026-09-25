package JAVA._Practice;

/**
 * [PG] 기초. ad제거하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : String.contains
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-07-06
 */

import java.util.*;

public class PG_lv0_기초_ad제거하기 {
	public static void main(String[] args){
	}

	class Solution {
		public String[] solution(String[] strArr) {
			List<String> list = new ArrayList<>();

			for (String str: strArr) {
				if (!str.contains("ad")) list.add(str);
			}

			String[] answer = new String[list.size()];
			for (int i=0; i<list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;
		}
	}
}
