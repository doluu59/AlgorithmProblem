package JAVA._Practice;

/**
 * [PG] 기초. 부분문자열 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : suubstring
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 18.
 */
 
public class PG_lv0_기초_부분문자열 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(String str1, String str2) {
			for (int i=0; i<str2.length()-str1.length()+1; i++) {
				if (str1.equals(str2.substring(i, i+str1.length()))) return 1;
			}
			return 0;
		}
	}
}
