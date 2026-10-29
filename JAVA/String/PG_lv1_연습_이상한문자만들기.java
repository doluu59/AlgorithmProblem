package JAVA.String;

/**
 * [PG] 이상한문자만들기 | 연습 · Lv.1
 *
 * @category String
 * @algorithm String Processing
 *
 * @implNote
 * - 문제 요약   : 각 단어에서 짝수 번째 알파벳은 대문자, 홀수 번째 알파벳은 소문자로 변환
 * - 풀이 전략   : 문자열을 순회하며 단어별 인덱스를 기준으로 대소문자 변환, 공백을 만나면 인덱스 초기화
 * - 시간 복잡도 : O(N) (N: 문자열 길이)
 * - 탐구 과정   : 공백을 기준으로 단어를 분리하지 않고, 공백을 만날 때마다 인덱스를 초기화하여 한 번의 순회로 처리
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12930">이상한 문자 만들기</a>
 */
 
public class PG_lv1_연습_이상한문자만들기 {
	public static void main(String[] args){
	}
	static class Solution {
		public String solution(String s) {
			StringBuilder sb = new StringBuilder();
			int idx = 0;

			for (int i=0; i<s.length(); i++) {
				char ch = s.charAt(i);
				ch = idx%2==0 ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
				idx = ch == ' ' ? 0 : idx + 1;

				sb.append(ch);
			}

			return sb.toString();
		}
	}
}
