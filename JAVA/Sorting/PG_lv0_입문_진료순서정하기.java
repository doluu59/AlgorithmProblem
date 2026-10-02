package JAVA.Sorting;

/**
 * [PG] 입문. 진료순서정하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 29.
 */
import java.util.*;

public class PG_lv0_입문_진료순서정하기 {
	public static void main(String[] args){
	}

	class Solution {
		public int[] solution(int[] emergency) {
			int len = emergency.length;
			int[] answer = new int[len];

			// 크기 순 정렬을 위한 배열
			Integer[] importance = new Integer[len];
			for (int i=0; i<len; i++) {
				importance[i] = emergency[i];
			}
			Arrays.sort(importance, (o1, o2) -> o2-o1 );

			// 중요도 순에 따른 순서대로 번호 매기기
			for (int i=0; i<len; i++) {
				for (int j=0; j<len; j++) {
					if (importance[j] == emergency[i]) {
						answer[i] = j+1;
						continue;
					}
				}
			}
			return answer;
		}
	}
}
