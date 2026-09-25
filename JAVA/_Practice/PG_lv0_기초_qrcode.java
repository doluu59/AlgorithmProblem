package JAVA._Practice;

/**
 * [PG] 기초. qrcode (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 24.
 */
 
public class PG_lv0_기초_qrcode {
	public static void main(String[] args){
	}
	class Solution {
		public String solution(int q, int r, String code) {
			StringBuilder sb = new StringBuilder();
			for (int i=r; i<code.length(); i += q) {
				sb.append(code.charAt(i));
			}
			return sb.toString();
		}
	}
}
