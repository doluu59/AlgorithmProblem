package JAVA.Hash.Set;

/**
 * [PG] 기초. 무작위로K개의수뽑기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 9.
 */

import java.util.*;

public class PG_lv0_기초_무작위로K개의수뽑기 {
	public static void main(String[] args){
	}

	class Solution {
		public int[] solution(int[] arr, int k) {
			int[] answer = new int[k];

			// Set
			Set<Integer> set = new LinkedHashSet<>();
			for (int num: arr) {
				set.add(num);
			}

			// set to array
			int[] setArr = new int[set.size()];
			int si=0;
			for (Integer num : set) {
				setArr[si++] = num;
			}

			// output
			for (int i=0; i<k; i++) {
				answer[i] = i < si ? setArr[i] : -1;
			}

			return answer;
		}
	}
}
