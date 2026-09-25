package JAVA._Practice;

/**
 * [PG] 기초. 문자열섞기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 19.
 */
 
public class PG_lv0_기초_문자열섞기 {
	public static void main(String[] args){
	}

	class Solution {
		public String solution(String str1, String str2) {
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<str1.length(); i++) {
				sb.append(str1.charAt(i));
				sb.append(str2.charAt(i));
			}
			return sb.toString();
		}
	}
}
