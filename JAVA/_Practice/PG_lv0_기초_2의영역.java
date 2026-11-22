package JAVA._Practice;

/**
 * [PG] 2의 영역 | 기초 · Lv.0
 *
 * @category Implementation
 * @algorithm Linear Search
 *
 * @implNote
 * - 문제 요약   : 배열에서 첫 번째 2부터 마지막 2까지의 구간 추출하기
 * - 풀이 전략   : 배열을 처음부터 순회하여 첫 번째 2의 인덱스 탐색
 *                 배열을 역순으로 순회하여 마지막 2의 인덱스 탐색
 *                 두 인덱스 사이의 구간을 새로운 배열에 복사
 *                 배열에 2가 존재하지 않으면 [-1] 반환
 * - 시간 복잡도 : O(N) (N = 배열의 길이)
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181894">2의 영역</a>
 */

public class PG_lv0_기초_2의영역 {
	static class Solution {
		public int[] solution(int[] arr) {
			// find range
			int start = -1;
			int end = -1;

			for (int i=0; i<arr.length; i++) {
				if (arr[i] == 2) {
					start = i;
					break;
				}
			}

			for (int i=arr.length-1; i>=0; i--) {
				if (arr[i] == 2) {
					end = i;
					break;
				}
			}

			// Exception
			if (start == -1 && end == -1) {
				return new int[] { -1 };
			}

			// copy arr
			int[] answer = new int[end-start+1];
			int idx=0;
			for(int i=start; i<=end; i++) {
				answer[idx++] = arr[i];
			}

			return answer;
		}
	}
}