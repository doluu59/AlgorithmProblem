package JAVA.Simulation;

/**
 * [PG] 조건에 맞게 수열 변환하기 2 | 기초 · Lv.0
 *
 * @category Simulation
 * @algorithm Iterative Simulation
 *
 * @implNote
 * - 문제 요약   : 배열의 각 원소를 주어진 조건에 따라 반복 변환하고,
 *                변환 전후의 배열이 같아지는 최초의 반복 횟수 반환
 * - 풀이 전략   : 매 반복마다 기존 배열을 복사한 뒤 조건에 따라 원소를 변환하고,
 *                이전 배열과 비교하여 변화가 없으면 반복 종료
 * - 시간 복잡도 : O(N × K) - N은 배열 길이, K는 변환 횟수
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181881">조건에 맞게 수열 변환하기 2</a>
 */
 
public class PG_lv0_기초_조건에맞게수열변환하기2 {
	public static class Solution {
		public int solution(int[] arr) {
			int answer = 0;
			boolean changed = true;

			while(changed) {
				changed = false;

				for (int i = 0; i < arr.length; i++) {
					int prev = arr[i];

					if (arr[i] >= 50 && arr[i] % 2 == 0) {
						arr[i] /= 2;
					} else if (arr[i] < 50 && arr[i] % 2 != 0) {
						arr[i] = arr[i] * 2 + 1;
					}

					if (prev != arr[i]) changed = true; // 변했는지
				}
				if (changed) answer++;
			}
			return answer;
		}
	}
}
