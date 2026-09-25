package JAVA._Practice;

/**
 * [PG] 기초. 부분문자열인지확인하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : substring
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-07-04
 */
 
public class PG_lv0_기초_부분문자열인지확인하기 {
	public static void main(String[] args){

	}
	class Solution {
		public int solution(String my_string, String target) {
			for (int i=0; i<my_string.length()-target.length()+1; i++) {
				if (target.equals(my_string.substring(i, i+target.length()))) return 1;
			}
			return 0;
		}
	}
}
