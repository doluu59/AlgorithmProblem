package JAVA._Practice;

/**
 * [BOJ] 기초. 공백으로구분하기2 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-18
 */
 
public class BOJ_lv0_기초_공백으로구분하기2 {
	public static void main(String[] args) {
	}
	class Solution {
		public String[] solution(String my_string) {
			String[] answer = my_string.trim().split("\\s+");
			return answer;
		}
	}
}
