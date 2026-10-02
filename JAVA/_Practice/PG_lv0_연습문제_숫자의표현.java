package JAVA._Practice;

/**
 * [PG] 연습문제. 숫자의표현 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 2.
 */
 
public class PG_lv0_연습문제_숫자의표현 {
	public static void main(String[] args){
	}
	static class Solution {
		public int solution(int n) {
			int answer = 0;

			for (int i = 1; i <= n; i++) {
				int sum = 0;

				// 현재 i부터 n까지 자연수를 더해가면서 합을 계산
				for (int j = i; j <= n; j++) {
					sum += j;

					// 현재 i부터 n까지 자연수를 더해가면서 합을 계산
					if (sum == n) {
						answer++;
						break;
					}

					// 합이 주어진 n보다 크면 내부 반복문 종료
					if (sum > n) break;
				}
			}

			return answer;
		}
	}
}
