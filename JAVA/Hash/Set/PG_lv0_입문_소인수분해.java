package JAVA.Hash.Set;

/**
 * [PG] 입문. 소인수분해 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 소인수 구하기
 * - 풀이 전략   : HashSet
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 22.
 */

import java.util.*;

public class PG_lv0_입문_소인수분해 {
	public static void main(String[] args){
	}

	class Solution {
		public int[] solution(int n) {
			Set<Integer> set = new LinkedHashSet<>();
			int i=2;
			while (n > 1) {
				if (n % i == 0) {
					n /= i;
					set.add(i);
				} else i++;
			}

			// set to array
			int[] answer = new int[set.size()];
			int j = 0;
			for (int num : set) {
				answer[j++] = num;
			}
			return answer;
		}
	}
}
