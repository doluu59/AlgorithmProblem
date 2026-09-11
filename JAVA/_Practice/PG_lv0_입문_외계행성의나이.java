package JAVA._Practice;

/**
 * [PG] 입문. 외계행성의나이 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 27.
 */
 
public class PG_lv0_입문_외계행성의나이 {
	public static void main(String[] args){
	}
	class Solution {
		public String solution(int age) {
			String str = String.valueOf(age);
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<str.length(); i++) {
				char ch = (char)(str.charAt(i) -'1' + 'a' + 1);
				sb.append(ch);
			}

			return sb.toString();
		}
	}
}
