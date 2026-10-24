package JAVA._Practice;

/**
 * [PG] 입문. 겹치는선분의길이 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 23.
 */

public class PG_lv0_입문_겹치는선분의길이 {
	public static void main(String[] args){
	}

	static class Solution {
		public int solution(int[][] lines) {
			int answer = 0;
			int[] cnt = new int[201];

			for(int[] arr : lines){
				int left = arr[0] + 100;
				int right = arr[1] + 100;

				for(int i = left; i<right; i++){
					cnt[i]++;
				}
			}

			for(int i : cnt){
				if(i > 1) answer++;
			}

			return answer;
		}
	}
}
