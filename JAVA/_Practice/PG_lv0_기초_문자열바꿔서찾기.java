package JAVA._Practice;

/**
 * [PG] 기초. 문자열바꿔서찾기 (lv0)
 * @category String
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : substring
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-23
 */
 
public class PG_lv0_기초_문자열바꿔서찾기 {
	public static void main(String[] args){
	}

	class Solution {
		public int solution(String myString, String pat) {
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<myString.length(); i++) {
				char ch = myString.charAt(i) == 'A' ? 'B' : 'A';
				sb.append(ch);
			}
			myString = sb.toString();
			for (int i=0; i<myString.length() - pat.length() + 1; i++) {
				if (pat.equals(myString.substring(i, i+pat.length()))) return 1;
			}
			return 0;
		}
	}
}
