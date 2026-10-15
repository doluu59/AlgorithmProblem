package JAVA._Practice;

/**
 * [PG] 기초. 리스트자르기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 24.
 */

import java.util.*;

public class PG_lv0_기초_리스트자르기 {
	public static void main(String[] args){
	}

	class Solution {
		public int[] solution(int n, int[] slicer, int[] num_list) {
			List<Integer> list =  new ArrayList<>();

			int start = 0;
			int end = num_list.length - 1;
			int interval = 1;
			switch (n) {
				case 1:
					end = slicer[1];
					break;
				case 2:
					start = slicer[0];
					break;
				case 3:
					start = slicer[0];
					end = slicer[1];
					break;
				default:
					start = slicer[0];
					end = slicer[1];
					interval = slicer[2];
					break;
			}

			for (int i = start; i <= end; i += interval) {
				list.add(num_list[i]);
			}

			int[] answer = new int[list.size()];
			for (int i=0; i<list.size(); i++) {
				answer[i] = list.get(i);
			}

			return answer;
		}
	}
}
