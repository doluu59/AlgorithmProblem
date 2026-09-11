package JAVA._Practice;

/**
 * [PG] 기초. 수열과구간커리1 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 6.
 */
 
public class PG_lv0_기초_수열과구간커리1 {
	public static void main(String[] args){
	}
	class Solution {
		public int[] solution(int[] arr, int[][] queries) {
			for(int[] query : queries) {
				for (int i=query[0]; i<=query[1]; i++) {
					arr[i]++;
				}
			}
			return arr;
		}
	}
}
