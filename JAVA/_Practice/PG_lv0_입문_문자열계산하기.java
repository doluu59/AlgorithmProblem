package JAVA._Practice;

/**
 * [PG] 입문. 문자열계산하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 13.
 */

import java.util.*;

public class PG_lv0_입문_문자열계산하기 {
	public static void main(String[] args){
	}

	class Solution {
		public int solution(String my_string) {
			StringTokenizer st = new StringTokenizer(my_string);

			int answer = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				String op = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				answer = op.equals("+") ? answer + num : answer - num;
			}
			return answer;
		}
	}
}
