package JAVA._Practice;

/**
 * [PG] 3진법뒤집기 | 월간코드챌린지 · Lv.1
 *
 * @category 
 * @algorithm 
 *
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 * - 탐구 과정 (생략 가능)
 *
 * @author   ysyoo
 * @see      <a href="">Problem Link</a>
 */
 
public class PG_lv1_월간코드챌린지_3진법뒤집기 {
	public static void main(String[] args){
	}
	static class Solution {
		public int solution(int n) {
			String str = "";

			while (n != 0) {
				str += n % 3;
				n /= 3;
			}

			return Integer.parseInt(str, 3);
		}
	}
}
