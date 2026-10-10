package JAVA._Practice;

/**
 * [PG] 입문. 7의개수 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 13.
 */
 
public class PG_lv0_입문_7의개수 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(int[] array) {
			int answer = 0;
			for (int num : array) {
				String str = String.valueOf(num);
				for (int i=0; i<str.length(); i++) {
					if (str.charAt(i) == '7') answer++;
				}
			}
			return answer;
		}
	}
}
