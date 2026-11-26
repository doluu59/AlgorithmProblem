package JAVA._Practice;

/**
 * [PG] 뒤에있는큰수찾기 | 연습 · Lv.2
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

import java.util.*;

public class PG_lv2_연습_뒤에있는큰수찾기 {

	class Solution {
		public int[] solution(int[] numbers) {
			Stack<Integer> st = new Stack<Integer>(); // 스택을 사용하여 뒷 큰수를 찾기 위한 자료구조를 생성

			int[] answer = new int[numbers.length]; // 결과를 저장할 배열 생성
			for (int i = numbers.length - 1; i >= 0; i--) { // 배열을 뒤에서부터 순회
				int number = numbers[i]; // 현재 원소
				answer[i] = -1; // 초기값으로 -1 설정 (뒷 큰수를 찾지 못하는 경우)
				while (!st.empty()) { // 스택이 비어있지 않을 때까지 반복
					int top = st.peek(); // 스택의 맨 위 원소 확인
					if (top > number) { // 스택의 맨 위 원소가 현재 원소보다 큰 경우
						answer[i] = top; // 현재 원소의 뒷 큰수로 스택의 맨 위 원소 설정
						break; // 뒷 큰수를 찾았으므로 반복문 종료
					}
					st.pop(); // 스택의 맨 위 원소를 제거 (뒷 큰수를 찾지 못한 경우)
				}
				st.add(number); // 현재 원소를 스택에 추가하여 다음 원소의 뒷 큰수를 찾을 준비
			}
			return answer; // 결과 배열 반환
		}
	}
}
