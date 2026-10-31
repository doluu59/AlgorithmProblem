package JAVA.String;

/**
 * [PG] 시저 암호 | 연습 · Lv.1
 *
 * @category String
 * @algorithm String
 *
 * @implNote
 * - 문제 요약   : 문자열의 각 알파벳을 n만큼 밀어 암호화하기
 * - 풀이 전략   : 대소문자를 구분하여 알파벳 순환 변환
 *                 공백은 그대로 유지하고, 알파벳은 26으로 나눈 나머지를 활용
 * - 시간 복잡도 : O(N) (N = 문자열 길이)
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12926">시저 암호</a>
 */
 
public class PG_lv1_연습_시저암호 {
	public static void main(String[] args){
	}

	static class Solution {
		public String solution(String s, int n) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch == ' ') {
					sb.append(ch);
					continue;
				}

				char nextCh = ch >= 'a' && ch <= 'z' ?
								(char) ((ch - 'a' + n) % 26 + 'a') :
								(char) ((ch - 'A' + n) % 26 + 'A');
				sb.append(nextCh);
			}
			return sb.toString();
		}
	}
}
