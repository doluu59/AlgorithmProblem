package JAVA._Practice;

/**
 * [PG] 입문. 가까운수 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 21.
 */
 
public class PG_lv0_입문_가까운수 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(int[] arr, int n) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			int len = arr.length;
			int[] diff = new int[len];

			for (int i=0; i<len; i++) {
				diff[i] = Math.abs(arr[i] - n);
				if (diff[i] < min) {
					min = diff[i];
					idx = i;
				} else if (diff[i] == min) {
					idx = arr[idx] < arr[i] ? idx : i;
				}
			}

			return arr[idx];
		}
	}
}
