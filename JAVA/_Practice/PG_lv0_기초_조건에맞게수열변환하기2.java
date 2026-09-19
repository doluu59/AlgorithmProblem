package JAVA._Practice;

/**
 * [PG] 기초. 조건에맞게수열변환하기2 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 12.
 */
 
public class PG_lv0_기초_조건에맞게수열변환하기2 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(int[] arr) {
			int answer = 0;
			boolean bool = true;
			while (bool) {
				answer++;
				bool = false;
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] >= 50 && arr[i] % 2 == 0) {
						arr[i] /= 2;
						bool = true;
					} else if (arr[i] < 50 && arr[i] % 2 != 0) {
						arr[i] = arr[i] * 2 + 1;
						bool = true;
					}
				}
			}
			return answer - 1;
		}
	}
}
