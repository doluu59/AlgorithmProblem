package JAVA._Practice;

/**
 * [PG] 기초. 세개의구분자 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 3.
 */
 
public class PG_lv0_기초_세개의구분자 {
	public static void main(String[] args){
	}

	class Solution {
		public String[] solution(String myStr) {
			String[] answer;
			String s = myStr.replaceAll("[a-c]", " ");
			if (s.trim().isEmpty()) {
				answer = new String[]{"EMPTY"};
			} else {
				answer = s.trim().split("\\s+");
			}
			return answer;

		}
	}
}
