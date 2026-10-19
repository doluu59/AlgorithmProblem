package JAVA.Hash.Map;

/**
 * [PG] 연습. 가장가까운같은글자 (lv1)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 19.
 */

import java.util.*;

public class PG_lv1_연습_가장가까운같은글자 {
	public static void main(String[] args){
	}
	static class Solution {
		public int[] solution(String s) {
			// 결과를 담을 배열 선언
			int[] answer = new int[s.length()];
			// s의 문자와 index를 담을 map 선언
			Map<Character, Integer> map = new HashMap<>();

			// s의 길이만큼 반복
			for (int i = 0; i < s.length(); i++) {
				// 해당 문자가 map에 없다면 -1
				if (!map.containsKey(s.charAt(i))) {
					answer[i] = -1;
					map.put(s.charAt(i), i);
				} else {
					// 해당 문자가 map에 존재하면 i - 이전 문자의 인덱스
					answer[i] = i - map.get(s.charAt(i));
					map.put(s.charAt(i), i);
				}
			}

			return answer;
		}
	}
}
