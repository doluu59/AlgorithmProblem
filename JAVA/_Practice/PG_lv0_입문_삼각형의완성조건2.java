package JAVA._Practice;

/**
 * [PG] 입문. 삼각형의완성조건2 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 15.
 */
 
public class PG_lv0_입문_삼각형의완성조건2 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(int[] sides) {
			int answer = 0;
			int max = Math.max(sides[0], sides[1]);
			int min = Math.min(sides[0], sides[1]);

			for (int i = max - min; i < max; i++) {
				answer++;
			}
			for (int i = max + min - 1; i > max; i--) {
				answer++;
			}
			return answer;
		}
	}
}
