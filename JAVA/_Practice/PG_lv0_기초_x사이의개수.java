package JAVA._Practice;

/**
 * [PG] 기초. x사이의개수 (lv0)
 * @category
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : String Split Method
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-16
 */
 
public class PG_lv0_기초_x사이의개수 {
	public static void main(String[] args) {
	}
	class Solution {
		public int[] solution(String myString) {
			String[] str = myString.split("x");
			int length = myString.charAt(myString.length()-1) == 'x' ? str.length + 1 : str.length;
			int[] answer = new int[length];
			for (int i=0; i<str.length; i++) {
				answer[i] = str[i].length();
			}
			return answer;
		}
	}
}
