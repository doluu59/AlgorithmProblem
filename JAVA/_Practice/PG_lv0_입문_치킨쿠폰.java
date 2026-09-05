package JAVA._Practice;

/**
 * [PG] 입문. 치킨쿠폰 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 31.
 */
 
public class PG_lv0_입문_치킨쿠폰 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(int chicken) {
			int answer = 0;
			while (chicken >= 10) {
				answer += chicken/10;
				chicken = chicken/10 + chicken%10;
			}
			return answer;
		}
	}
}
