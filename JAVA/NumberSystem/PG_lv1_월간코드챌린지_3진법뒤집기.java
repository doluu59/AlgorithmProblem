package JAVA.NumberSystem;

/**
 * [PG] 3진법뒤집기 | 월간코드챌린지 · Lv.1
 *
 * @category NumberSystem
 * @algorithm Base Conversion
 *
 * @implNote
 * - 문제 요약   : 자연수 n을 3진법으로 변환한 뒤 자릿수를 반전하여 10진법으로 변환
 * - 풀이 전략   : 나머지 연산과 나눗셈으로 3진수의 자릿수를 역순으로 추출하고, parseInt()로 10진수 변환
 * - 시간 복잡도 : O(log N) (N: 입력값 n)
 * - 탐구 과정   : 나머지를 추출하는 순서대로 저장하면 별도의 문자열 반전 없이 3진수 자릿수를 뒤집을 수 있음
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/68935">3진법 뒤집기</a>
 */

import java.util.*;

public class PG_lv1_월간코드챌린지_3진법뒤집기 {
	public static void main(String[] args){
	}
	static class Solution {
		public int solution(int n) {
			StringBuilder sb = new StringBuilder();

			// 3진수 반전으로 string 저장
			for (int i=0; n>0; i++) {
				sb.append(n%3);
				n/=3;
			}

			// 3진수 -> 10진수 변환
			int answer = Integer.parseInt(sb.toString(), 3);
			return answer;
		}
	}
}
