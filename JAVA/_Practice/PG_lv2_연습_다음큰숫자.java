package JAVA._Practice;

/**
 * [PG] 다음큰숫자 | 연습 · Lv.2
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


public class PG_lv2_연습_다음큰숫자 {
	class Solution {
		public int solution(int n) {
			int answer = 0;
			int num1 = n;
			int numOfOne = 0;

			while(true) {
				numOfOne += num1 % 2;
				num1 /= 2;
				if(num1 == 0)
					break;
			}

			for(int i = n + 1; i <= 1000000; i++) {
				int numOfOne2 = 0;
				int num2 = i;
				boolean flag = false;
				while(true) {
					numOfOne2 += num2 % 2;
					num2 /= 2;
					if(num2 == 0) {
						flag = true;
						break;
					}
				}
				if(flag == true && numOfOne2 == numOfOne) {
					answer = i;
					break;
				}
			}

			return answer;
		}
	}
}
