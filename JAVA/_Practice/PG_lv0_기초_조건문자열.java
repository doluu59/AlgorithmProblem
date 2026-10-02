package JAVA._Practice;

/**
 * [PG] 기초. 조건문자열 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 26.
 */
 
public class PG_lv0_기초_조건문자열 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(String ineq, String eq, int n, int m) {
			int answer = 0;
			if (ineq.equals("<")) {
				if (eq.equals("=")) answer = n <= m ? 1 : 0;
				else answer = n < m ? 1 : 0;
			} else {
				if (eq.equals("=")) answer = n >= m ? 1 : 0;
				else answer = n > m ? 1 : 0;
			}
			return answer;
		}
	}
}
