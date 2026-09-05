package JAVA._Practice;

/**
 * [PG] 기초. 꼬리문자열 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : contains
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-07-05
 */
 
public class PG_lv0_기초_꼬리문자열 {
	public static void main(String[] args){

	}

	class Solution {
		public String solution(String[] str_list, String ex) {
			StringBuilder sb = new StringBuilder();
			for (String str: str_list) {
				if (!str.contains(ex)) sb.append(str);
			}
			return sb.toString();
		}
	}
}
