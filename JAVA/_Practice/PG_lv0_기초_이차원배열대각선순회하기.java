package JAVA._Practice;

/**
 * [PG] 기초. 이차원배열대각선순회하기 (lc0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 28.
 */
 
public class PG_lv0_기초_이차원배열대각선순회하기 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(int[][] board, int k) {
			int answer = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (i + j <= k) answer += board[i][j];
				}
			}
			return answer;
		}
	}
}
