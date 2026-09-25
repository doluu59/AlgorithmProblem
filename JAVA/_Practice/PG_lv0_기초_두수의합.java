package JAVA._Practice;

/**
 * [PG] 기초. 두수의합 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 14.
 */

import java.util.*;

public class PG_lv0_기초_두수의합 {
	public static void main(String[] args){
	}
	class Solution {
		public String solution(String a, String b) {
			StringBuilder sb = new StringBuilder();
			int aLen = a.length() - 1, bLen = b.length() - 1;

			Deque<Integer> stack = new ArrayDeque<>();
			int carry = 0;
			while (aLen >= 0 || bLen >= 0 || carry > 0) {
				int sum = carry;

				if (aLen >= 0) sum += a.charAt(aLen--) - '0';
				if (bLen >= 0) sum += b.charAt(bLen--) - '0';

				if (sum >= 10) {
					carry = 1;
					sum-=10;
				} else carry = 0;

				stack.offerLast(sum);
			}

			while (!stack.isEmpty()) {
				sb.append(stack.pollLast());
			}
			return sb.toString();
		}
	}
}
