package JAVA._Practice;

/**
 * [PG] 기초. A강조하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-20
 */
 
public class PG_lv0_기초_A강조하기 {
	public static void main(String[] args) {
	}

	static class Solution {
		public String solution(String myString) {
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<myString.length(); i++) {
				char ch = myString.charAt(i);
				if (ch == 'a') sb.append('A');
				else if (ch >= 'B' && ch <= 'Z') sb.append((char)(ch-'A'+'a'));
				else sb.append(ch);
			}
			return sb.toString();
		}
	}
}
