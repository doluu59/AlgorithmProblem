package JAVA._Practice;

/**
 * [PG] 기초. 수열과구간쿼리3 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 17.
 */
 
public class PG_lv0_기초_수열과구간쿼리3 {
	public static void main(String[] args){
	}
	class Solution {
		public int[] solution(int[] arr, int[][] queries) {
			for (int[] query : queries) {
				int tmp = arr[query[0]];
				arr[query[0]] = arr[query[1]];
				arr[query[1]] = tmp;
			}
			return arr;
		}
	}
}
