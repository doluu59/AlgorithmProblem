package JAVA._Practice;

/**
 * [PG] 기초. 문자열이몇번등장하는지세기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : substring
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 22.
 */
 
public class PG_lv0_기초_문자열이몇번등장하는지세기 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(String myString, String pat) {
			int answer = 0;
			for (int i=0; i<=myString.length()-pat.length(); i++) {
				if (pat.equals(myString.substring(i, i+pat.length()))) answer++;
			}
			return answer;
		}
	}
}
