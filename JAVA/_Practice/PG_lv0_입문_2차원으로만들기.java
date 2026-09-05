package JAVA._Practice;

/**
 * [PG] 입문. 2차원으로만들기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 10.
 */
 
public class PG_lv0_입문_2차원으로만들기 {
	public static void main(String[] args){
	}
	class Solution {
		public int[][] solution(int[] num_list, int n) {
			int[][] answer = new int[num_list.length/n][n];
			for (int i=0; i<num_list.length; i++) {
				answer[i/n][i%n] = num_list[i];
			}
			return answer;
		}
	}
}
