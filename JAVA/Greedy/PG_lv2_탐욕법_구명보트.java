package JAVA.Greedy;

/**
 * [PG] 구명보트 | 탐욕법 · Lv.2
 *
 * @category 
 * @algorithm 
 *
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 * - 탐구 과정 (생략 가능)
 *
 * @author   ysyoo
 * @see      <a href="">Problem Link</a>
 */

import java.util.*;

public class PG_lv2_탐욕법_구명보트 {
	class Solution {
		public int solution(int[] people, int limit) {
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < people.length; i++) {
				arr.add(people[i]);
			}
			int answer = 0;

			Collections.sort(arr, Collections.reverseOrder());

			int left = 0;
			int right = arr.size() - 1;

			while(left <= right) {
				int sum = 0;
				sum = arr.get(left) + arr.get(right);

				if(sum <= limit) {;
					left += 1;
					right -= 1;
				} else {
					left += 1;
				}
				answer += 1;
			}
			return answer;
		}
	}
}
