package JAVA._Practice;

/**
 * [PG] 입문. 한번만등장한문자 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 28.
 */
 
public class PG_lv0_입문_한번만등장한문자 {
	public static void main(String[] args){
	}
	class Solution {
		public String solution(String s) {
			int[] alphabet = new int[26];
			for (char ch : s.toCharArray()) {
				alphabet[ch - 'a'] ++;
			}

			StringBuilder sb = new StringBuilder();
			for (int i=0; i<26; i++) {
				if (alphabet[i] == 1) sb.append((char)(i + 'a'));
			}
			String answer = sb.toString();
			return answer;
		}
	}
}
