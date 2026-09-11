package JAVA._Practice;

/**
 * [PG] 기초. 배열의원소삭제하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 25.
 */

import java.util.*;

public class PG_lv0_기초_배열의원소삭제하기 {
	public static void main(String[] args){
	}

	class Solution {
		public int[] solution(int[] arr, int[] delete_list) {
			// 삭제할 원소 체크
			boolean[] checkList = new boolean[1001];
			for (int deleteNum : delete_list) {
				checkList[deleteNum] = true;
			}

			// 삭제할 원소인지 체크
			List<Integer> list = new ArrayList<>();
			for (int num : arr) {
				if (!checkList[num]) list.add(num);
			}

			// Array to List
			int[] answer = list.stream()
							.mapToInt(Integer:: intValue).toArray();

			return answer;
		}
	}
}
