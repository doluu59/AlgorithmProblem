package JAVA._Practice;

/**
 * [PG] 기초. 문자열잘라서정렬하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : split, sort
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-25
 */

import java.util.*;

public class PG_lv0_기초_문자열잘라서정렬하기 {
	public static void main(String[] args) {
	}
	class Solution {
		public String[] solution(String myString) {
			String[] arr = myString.split("x");
			Arrays.sort(arr);
			List<String> list = new ArrayList<>();
			for (int i=0; i<arr.length; i++) {
				if (!arr[i].equals("")) list.add(arr[i]);
			}
			String[] answer = new String[list.size()];
			for (int i=0; i<list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;
		}
	}
}
