package JAVA._Practice;

/**
 * [PG] 기초. 코드처리하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 2.
 */
 
public class PG_lv0_기초_코드처리하기 {
	public static void main(String[] args){
	}

	class Solution {
		public String solution(String code) {
			StringBuilder sb = new StringBuilder();

			int mode = 0;
			for (int i=0; i<code.length(); i++) {
				if (code.charAt(i)=='1') {
					mode = mode == 0 ? 1 : 0;
					continue;
				}
				if (mode == i%2) sb.append(code.charAt(i));
			}

			if (sb.toString().isEmpty()) sb.append("EMPTY");
			return sb.toString();
		}
	}
}
