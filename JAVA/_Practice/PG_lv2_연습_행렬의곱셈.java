package JAVA._Practice;

/**
 * [PG] 행렬의곱셈 | 연습 · Lv.2
 *
 * @category 
 * @algorithm 
 *
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 * - 탐구 과정 (생략 가능)
 *
 * @author   ysyoo
 * @see      <a href="">Problem Link</a>
 */
 
public class PG_lv2_연습_행렬의곱셈 {
	class Solution {

		public int[][] solution(int[][] arr1, int[][] arr2) {
			int[][] arr = new int[arr1.length][arr2[0].length];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = 0;
					for (int k = 0; k < arr1[i].length; k++) {
						arr[i][j] += arr1[i][k] * arr2[k][j];
					}
				}
			}
			return arr;
		}

	}
}
