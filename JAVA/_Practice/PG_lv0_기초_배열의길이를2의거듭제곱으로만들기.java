package JAVA._Practice;

/**
 * [PG] 기초. 배열의길이를2의거듭제곱으로만들기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 16.
 */
 
public class PG_lv0_기초_배열의길이를2의거듭제곱으로만들기 {
	public static void main(String[] args){
	}
	class Solution {
		public int[] solution(int[] arr) {
			int len = 1;

			while (len < arr.length) {
				len *= 2;
			}

			int[] answer = new int[len];
			for (int i=0; i<arr.length; i++) {
				answer[i] = arr[i];
			}
			return answer;
		}
	}
}
