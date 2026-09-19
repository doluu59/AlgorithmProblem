package JAVA._Practice;

/**
 * [PG] 기초. 2의영역 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 11.
 */

import java.util.Arrays;

public class PG_lv0_기초_2의영역 {
	public int[] solution(int[] arr) {
		int min = 100000, max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 2) {
				min = Math.min(min, i);
				max = Math.max(max, i);
			}
		}

		if (min <= max) {
			return Arrays.copyOfRange(arr, min, max + 1);
		} else {
			return new int[]{-1};
		}
	}
}
