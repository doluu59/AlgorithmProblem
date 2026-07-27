package JAVA._Practice;

/**
 * [PG] 기초. 문자개수세기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 27.
 */
 
public class PG_lv0_기초_문자개수세기 {
	public static void main(String[] args){
	}
	class Solution {
		public int[] solution(String my_string) {
			int[] answer = new int[52];
			for (int i=0; i<my_string.length(); i++) {
				char ch = my_string.charAt(i);
				if (ch >= 'A' && ch <= 'Z') {
					answer[ch-'A'] ++;
				} else {
					answer[ch-'a' + 26]++;
				}
			}
			return answer;
		}
	}
}
