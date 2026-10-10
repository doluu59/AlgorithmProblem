package JAVA._Practice;

/**
 * [PG] 입문. 공던지기 (lv0)
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
 
public class PG_lv0_입문_공던지기 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(int[] numbers, int k) {
			int n = 0;
			for (int i=1; i<k; i++) {
				n += 2;
			}

			return numbers[n%numbers.length];
		}
	}
}
