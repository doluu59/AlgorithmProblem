package JAVA._Practice;

/**
 * [PG] 입문. 구슬을나누는경우의수 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 14.
 */
 
public class PG_lv0_입문_구슬을나누는경우의수 {
	public static void main(String[] args){
	}

	class Solution {
		public long solution(int balls, int share) {
			long answer = 1;

			// 조합 개수 구하는 공식
			for(int i=0; i<share; i++){
				answer *= (balls - i);  // 분자 : n부터 n-m+1까지 나눔
				answer /= (i + 1);      // 분모 : 1부터 m까지를 나눔
			}

			return answer;
		}
	}
}
