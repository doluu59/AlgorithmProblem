package JAVA.String;

/**
 * [PG] 숨어있는 숫자의 덧셈 (2) | 입문 · Lv.0
 *
 * @category String
 * @algorithm String Parsing
 *
 * @implNote
 * - 문제 요약   : 문자열에 포함된 연속된 숫자들을 각각 정수로 변환하여 합산
 * - 풀이 전략   : 문자열을 순회하며 숫자는 StringBuilder에 누적하고,
 *                문자를 만나면 누적된 숫자를 정수로 변환하여 합산
 * - 시간 복잡도 : O(N)
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120864">숨어있는 숫자의 덧셈 (2)</a>
 */
 
public class PG_lv0_입문_숨어있는숫자의덧셈2 {
	static class Solution {
		public int solution(String my_string) {
			int answer = 0;

			StringBuilder sb = new StringBuilder();
			for (char c : my_string.toCharArray()) {
				if (c >= '0' && c <= '9') {
					sb.append(c);
				} else {
					if (sb.length() == 0) continue;
					answer += Integer.parseInt(sb.toString());
					sb.setLength(0);
				}
			}

			if (sb.length() != 0) answer += Integer.parseInt(sb.toString());

			return answer;
		}
	}
}
