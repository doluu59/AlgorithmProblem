package JAVA.Mathematics;

/**
 * [PG] 입문. k의개수 (lv0)
 * @category Mathematics
 * @algorithm Digit Counting
 * @implNote
 * - 문제 요약   : i부터 j까지의 정수에서 숫자 k가 등장하는 횟수를 구한다.
 * - 풀이 전략   : 범위의 모든 숫자를 순회하며 각 자릿수를 확인한다.
 * 								최적화 - 각 자릿수에서 k가 등장하는 횟수를 계산하여 전체 숫자를 순회하지 않는다.
 * - 시간 복잡도 : O(NlogN), 최적화 시 : O(logN)
 *
 * (탐구 과정)
 *   단순히 i ~ j의 모든 숫자를 순회 대신,
 *     -> 각 자리에서 k가 등장하는 횟수를 한 번에 계산하는 방법으로 최적화
 *
 *   예를 들어, N = 3456, k = 5라면, 다음과 같이 각 자리에서 규칙적으로 등장한다.
 *     1) 일의 자리 : 5, 15, 25, ...
 *     2) 십의 자리 : 50 ~ 59, 150 ~ 159, ...
 *     3) 백의 자리 : 500 ~ 599, 1500 ~ 1599, ...
 *   이를 현재 자리 기준으로 앞쪽 숫자(high), 현재 숫자(cur), 뒤쪽 숫자(low)로 나누어 계산했다.
 *   * 단, k = 0인 경우 맨 앞자리의 의미 없는 0이 포함되지 않도록 별도로 처리한다.
 *
 * @author ysyoo
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120887">Programmers - k의 개수</a>
 */

public class PG_lv0_입문_k의개수 {
	public static void main(String[] args){
	}

	// 각 자리에서 k가 등장하는 횟수를 계산하는 최적화 풀이. [O(logN)]
	static class Solution {
		public int solution(int i, int j, int k) {
			return count(j, k) - count(i - 1, k);
		}

		// 1 ~ n에서 k가 등장하는 횟수
		private int count(int n, int k) {
			if (n <= 0) return 0;

			int answer = 0;
			// factor = 1  → 일의 자리, factor = 10 → 십의 자리
			for (int factor = 1; factor <= n; factor *= 10) {
				int high = n / (factor * 10);		// high : 앞쪽 숫자
				int cur = (n / factor) % 10;		// cur  : 현재 자리 숫자
				int low = n % factor;						// low  : 뒤쪽 숫자

				if (k != 0) {
					if (cur > k) {					// 현재 자리가 k보다 큰 경우
						answer += (high + 1) * factor;
					} else if (cur == k) {	// 현재 자리가 k와 같은 경우
						answer += high * factor + low + 1;
					} else {								// 현재 자리가 k보다 작은 경우
						answer += high * factor;
					}
				} else {	// k == 0
					// 맨 앞자리의 의미 없는 0은 세면 안 됨
					if (high == 0) {
						continue;
					}

					if (cur == 0) {
						answer += (high - 1) * factor + low + 1;
					} else {
						answer += (high - 1) * factor + factor;
					}
				}
			}

			return answer;
		}
	}

	/*
	// 기본 풀이
  // 모든 숫자를 순회하면서 각 자릿수를 직접 확인한다. [O(NlogN)]
	static class Solution {
		public int solution(int i, int j, int k) {
			int answer = 0;

			for (; i<=j; i++) {
				int num = i;

				while (num > 0) {
					if (num%10 == k) answer++;
					num /= 10;
				}
			}
			return answer;
		}
	}
	 */
}