package JAVA._Practice;

/**
 * [PG] 기초. 배열에서문자열대소문자변환하기 (lv0)
 * @category Practice
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : toLowerCase(), toUpperCase()
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-21
 */
 
public class PG_lv0_기초_배열에서문자열대소문자변환하기 {
	public static void main(String[] args){

	}
	class Solution {
		public String[] solution(String[] strArr) {
			String[] answer = new String[strArr.length];

			for (int i=0; i<strArr.length; i++) {
				if (i%2 == 0) {
					answer[i] = strArr[i].toLowerCase();
				} else {
					answer[i] = strArr[i].toUpperCase();
				}
			}
			return answer;
		}
	}
}
