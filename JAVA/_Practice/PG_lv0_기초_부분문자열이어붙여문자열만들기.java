package JAVA._Practice;

/**
 * [PG] 기초. 부분문자열이어붙여문자열만들기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : substring
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 17.
 */
 
public class PG_lv0_기초_부분문자열이어붙여문자열만들기 {
	public static void main(String[] args){
	}
	class Solution {
		public String solution(String[] my_strings, int[][] parts) {
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<my_strings.length; i++) {
				sb.append(my_strings[i].substring(parts[i][0], parts[i][1]+1));
//				sb.append(my_strings[i],parts[i][0], parts[i][1]+1);
			}
			return sb.toString();
		}
	}
}
