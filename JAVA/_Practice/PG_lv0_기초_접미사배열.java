package JAVA._Practice;

import java.util.*;

/**
 * [PG] 기초. 접미사배열 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : substring, sort
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-07-01
 */
 
public class PG_lv0_기초_접미사배열 {
	public static void main(String[] args){
	}

	class Solution {
		public String[] solution(String my_string) {
			List<String> list = new ArrayList<>();
			for (int i=0; i<my_string.length(); i++) {
				list.add(my_string.substring(i, my_string.length()));
			}
			String[] answer = new String[list.size()];
			for (int i=0; i<list.size(); i++){
				answer[i] = list.get(i);
			}
			Arrays.sort(answer);
			return answer;
		}
	}
}
