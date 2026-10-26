package JAVA.Simulation;

/**
 * [PG] 이진변환반복하기 | 월간코드챌린지 · Lv.2
 *
 * @category Simulation
 * @algorithm String, 구현
 *
 * @implNote
 * - 문제 요약   : 2진수를 주어진 규칙에 따라 반복 변환하기
 * - 풀이 전략   : 문자열을 순회하며 0을 제거하고, 새로운 2진수 만들기 (Integer.toBinaryString() 활용)
 * - 시간 복잡도 : O(N × K) (N: 초기 문자열 길이, K: 이진 변환 반복 횟수)
 * - 탐구 과정 (생략 가능)
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/70129">이진 변환 반복하기</a>
 */
 
public class PG_lv2_월간코드챌린지_이진변환반복하기 {
	public static void main(String[] args){
	}

	static class Solution {
		public int[] solution(String s) {
			int cnt = 0;
			int zeroCnt = 0;
			while (!s.equals("1")) {
				// step 1
				StringBuilder sb = new StringBuilder();
				for (int i=0; i<s.length(); i++) {
					if (s.charAt(i) == '1') sb.append("1");
					else zeroCnt++;
				}

				// step 2
				int num = sb.toString().length();
				s = Integer.toBinaryString(num);
				cnt++;
			}

			return new int[]{ cnt, zeroCnt };
		}
	}
}
