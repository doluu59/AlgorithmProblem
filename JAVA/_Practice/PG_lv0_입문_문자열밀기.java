package JAVA._Practice;

/**
 * [PG] 입문. 문자열밀기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 11.
 */

import java.lang.StringBuilder;

public class PG_lv0_입문_문자열밀기 {
	public static void main(String[] args){
	}
	static class Solution {
		public int solution(String A, String B) {
			int answer = -1;
			if (A.equals(B)) {
				answer = 0;
			}
			for (int i = 0; i < A.length(); i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = A.length() - i; j < A.length(); j++) {
					sb.append(A.charAt(j));
				}
				for (int j = 0; j < A.length() - i; j++) {
					sb.append(A.charAt(j));
				}
				if (sb.toString().equals(B)) {
					answer = i;
					break;
				}
			}
			return answer;
		}
	}
}
