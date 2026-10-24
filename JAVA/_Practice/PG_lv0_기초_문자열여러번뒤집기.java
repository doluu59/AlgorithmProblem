package JAVA._Practice;

/**
 * [PG] 기초. 문자열여러번뒤집기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : substring, replace
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 8.
 */
 
public class PG_lv0_기초_문자열여러번뒤집기 {
	public static void main(String[] args){
	}

	class Solution {
		public String solution(String my_string, int[][] queries) {
			StringBuilder sb = new StringBuilder();
			sb.append(my_string);

			for (int[] query : queries) {
				String substr = sb.substring(query[0], query[1]+1);
				StringBuilder reverse = new StringBuilder();
				reverse.append(substr);
				reverse.reverse();
				sb.replace(query[0], query[1]+1, reverse.toString());
			}
			return sb.toString();
		}
	}
}
