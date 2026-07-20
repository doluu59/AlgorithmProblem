package JAVA._Practice;

/**
 * [PG] 기초. 문자열뒤집기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 20.
 */

import java.util.*;

public class PG_lv0_기초_문자열뒤집기 {
	public static void main(String[] args){
	}

	class Solution {
		public String solution(String my_string, int s, int e) {
			StringBuilder sb = new StringBuilder();

			ArrayDeque<Character> stack = new ArrayDeque<>();
			for (int i=s; i<=e; i++) {
				stack.offerLast(my_string.charAt(i));
			}

			for (int i=0; i<my_string.length(); i++) {
				if (i < s || i > e) sb.append(my_string.charAt(i));
				else sb.append(stack.pollLast());
			}
			return sb.toString();
		}
	}
}
