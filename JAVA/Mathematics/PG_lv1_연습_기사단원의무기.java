package JAVA.Mathematics;

/**
 * [PG] 기사단원의 무기 | 연습 · Lv.1
 *
 * @category Mathematics
 * @algorithm Divisor Counting
 *
 * @implNote
 * - 문제 요약   : 각 기사의 번호에 해당하는 약수의 개수를 공격력으로 사용하고 제한 초과 시 지정된 공격력으로 대체
 * - 풀이 전략   : 각 번호의 약수 개수를 구해 기사별 공격력 계산
 *                 약수는 쌍으로 존재하는 성질을 이용하여 제곱근까지만 탐색
 *                 제곱수는 제곱근이 중복 계산되지 않도록 별도 처리
 *                 공격력이 제한 수치를 초과하면 지정된 공격력으로 대체하여 합산
 * - 시간 복잡도 : O(N√N) (N = 기사 수)
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/136798">기사단원의 무기</a>
 */
 
public class PG_lv1_연습_기사단원의무기 {
	static class Solution {
		public int solution(int number, int limit, int power) {
			int answer = 0;
			int[] knight = getPower(number);

			// 제한 처리
			for (int i = 0; i < number; i++) {
				answer += knight[i] <= limit ? knight[i] : power;
			}
			return answer;
		}

		// 기사들의 공격력 구하기
		public int[] getPower(int number) {
			int[] knight = new int[number];

			for (int i = 0; i < number; i++) {
				knight[i] = getNumOfDiv(i+1);
			}

			return knight;
		}

		// 약수 개수 구하기
		int getNumOfDiv(int number) {
			int count = 0;

			for (int i = 1; i < number / i; i++) {
				if (number % i == 0) count += 2;
			}

			// 제곱근 처리
			int sqrt = (int) Math.sqrt(number);
			if (sqrt * sqrt == number) count++;

			return count;
		}
	}
}
