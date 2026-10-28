package JAVA.String;

/**
 * [PG] 가장가까운같은글자 | 연습 · Lv.1
 *
 * @category String
 * @algorithm Array
 *
 * @implNote
 * - 문제 요약   : 문자열의 각 문자에 대해 이전에 등장한 동일 문자와의 가장 가까운 거리 구하기
 * - 풀이 전략   : 알파벳별 마지막 등장 인덱스를 배열에 저장하여 현재 문자와의 거리 계산
 * - 시간 복잡도 : O(N) (N: 문자열 길이)
 * - 탐구 과정   : 알파벳 개수만큼 크기가 26인 배열을 사용해 알파벳별 마지막 등장 위치를 저장. O(1)에 조회
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/142086">가장 가까운 같은 글자</a>
 */

import java.util.Arrays;

public class PG_lv1_연습_가장가까운같은글자 {
	public static void main(String[] args){
	}

	static class Solution {
		public int[] solution(String s) {
			int[] lastIdx = new int[26];   // 알파벳이 가장 최근에 나온 인덱스 값 저장 (i=0이면 a, ...)
			int[] answer = new int[s.length()];
			Arrays.fill(lastIdx, -1);

			// 처음 나온 알파벳이면 -1, 아니면 현재 idx와의 거리
			for (int i=0; i<s.length(); i++) {
				int charIdx = s.charAt(i) - 'a';
				answer[i] = lastIdx[charIdx] == -1 ? -1 : i - lastIdx[charIdx];
				lastIdx[charIdx] = i;        // 알파벳 등장 update
			}

			return answer;
		}
	}
}
