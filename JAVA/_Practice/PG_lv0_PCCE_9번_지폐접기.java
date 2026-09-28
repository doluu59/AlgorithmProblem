package JAVA._Practice;

/**
 * [PG] PCCE. 9번 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 28.
 */
 
public class PG_lv0_PCCE_9번_지폐접기 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(int[] wallet, int[] bill) {
			int answer = 0;
			while(Math.min(bill[0], bill[1]) > Math.min(wallet[0], wallet[1]) ||
							Math.max(bill[0], bill[1]) > Math.max(wallet[0], wallet[1])) {
				if (bill[0] > bill[1]) bill[0] /= 2;
				else bill[1] /= 2;
				answer += 1;
			}
			return answer;
		}
	}
}
