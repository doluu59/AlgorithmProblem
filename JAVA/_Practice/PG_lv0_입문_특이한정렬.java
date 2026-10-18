package JAVA._Practice;

/**
 * [PG] 입문. 특이한정렬 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 18.
 */

import java.util.*;

public class PG_lv0_입문_특이한정렬 {
	public static void main(String[] args){
	}
	static class Solution {
		public int[] solution(int[] numlist, int n) {
			int[] answer = new int[numlist.length];

			ArrayList<Integer> list = new ArrayList<>();

			for(int i=0; i<numlist.length; i++) {
				list.add(numlist[i]);
			}

			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer n1, Integer n2) {
					int gap1 = Math.abs(n1 -n);
					int gap2 = Math.abs(n2-n);

					if(gap1==gap2) return n2 - n1;

					return gap1 - gap2;
				}
			});

			for(int i=0; i<answer.length; i++) {
				answer[i] = list.get(i);
			}

			return answer;
		}
	}
}
