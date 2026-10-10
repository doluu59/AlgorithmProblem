package JAVA._Practice;

/**
 * [PG] 기초. 특별한이차원배열2 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 9.
 */
 
public class PG_lv0_기초_특별한이차원배열2 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(int[][] arr) {
			for (int i=0; i<arr.length; i++) {
				for (int j=i+1; j<arr.length-i; i++) {
					if (arr[i][j] != arr[j][i]) return 0;
				}
			}
			return 1;
		}
	}
}
