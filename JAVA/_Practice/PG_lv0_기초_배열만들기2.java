package JAVA._Practice;

/**
 * [PG] 기초. 배열만들기2 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 12.
 */

import java.util.*;

public class PG_lv0_기초_배열만들기2 {
	public static void main(String[] args){
	}
	static class Solution {
		public int[] solution(int l, int r) {
			ArrayList<Integer> al = new ArrayList<>();
			for(int i = l; i <= r; i++) {
				String str = i + "";
				int cnt = 0;
				for(int j = 0; j < str.length(); j++) {
					if(str.charAt(j) == '0' || str.charAt(j) == '5') {
						cnt ++;
					}
				}
				if(cnt == str.length()) {
					al.add(i);
				}
			}

			int[] answer = new int[al.size()];
			for (int i = 0; i < al.size(); i++) {
				answer[i] = al.get(i);
			}

			int[] empty = {-1};
			if(answer.length == 0) return empty;

			return answer;
		}
	}
}
