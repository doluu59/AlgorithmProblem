package JAVA._Practice;

/**
 * [PG] 기초. 주사위게임1 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-24
 */

public class PG_lv0_기초_주사위게임1 {
	public static void main(String[] args){
	}

	class Solution {
		public int solution(int a, int b) {
			int answer = 0;
			// a b 홀수
			if (a*b % 2 != 0) answer = a*a+b*b;
				// a b 짝수
			else if (a%2==0 && b%2==0) answer = Math.abs(a-b);
				// 하나만 홀수
			else answer = 2*(a+b);
			return answer;
		}
	}
}
