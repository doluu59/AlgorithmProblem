package JAVA._Practice;

/**
 * [PG] 기초. 순서바꾸기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 16.
 */
import java.util.*;

public class PG_lv0_기초_순서바꾸기 {
	public static void main(String[] args){
	}

	class Solution {
		public int[] solution(int[] num_list, int n) {

			List<Integer> list = new ArrayList<>();
			for (int i=n; i<num_list.length; i++) {
				list.add(num_list[i]);
			}
			for (int i=0; i<n; i++) {
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
