package JAVA._Practice;

/**
 * [PG] 입문. A로B만들기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 29.
 */
 
public class PG_lv0_입문_A로B만들기 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(String before, String after) {
			int[] a1 = new int[26];
			int[] a2 = new int[26];
			for (char ch : before.toCharArray()) {
				a1[(char)(ch - 'a')] ++;
			}
			for (char ch : after.toCharArray()) {
				a2[(char)(ch - 'a')] ++;
			}
			for (int i=0; i<26; i++) {
				if (a1[i] != a2[i]) return 0;
			}
			return 1;
		}
	}
}
