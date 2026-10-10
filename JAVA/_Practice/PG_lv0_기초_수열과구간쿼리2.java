package JAVA._Practice;

/**
 * [PG] 기초. 수열과구간쿼리2 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 20.
 */
 
public class PG_lv0_기초_수열과구간쿼리2 {
	public static void main(String[] args){
	}
	class Solution {
		public int[] solution(int[] arr, int[][] queries) {
			int[] answer = new int[queries.length];
			int idx = 0;
			for (int[] query : queries) {
				int s = query[0];
				int e = query[1];
				int k = query[2];
				int min = Integer.MAX_VALUE;
				for (int i=s; i<=e; i++) {
					if (arr[i]>k) min = Math.min(min, arr[i]);
				}
				answer[idx++] = min == Integer.MAX_VALUE ? -1 : min;
			}
			return answer;
		}
	}
}
