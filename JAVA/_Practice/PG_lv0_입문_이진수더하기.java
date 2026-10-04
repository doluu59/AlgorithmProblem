package JAVA._Practice;

/**
 * [PG] 입문. 이진수더하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 4.
 */
 
public class PG_lv0_입문_이진수더하기 {
	public static void main(String[] args){
	}
	static class Solution {
		public String solution(String bin1, String bin2) {
			String answer = "";
			int binOne = Integer.parseInt(bin1, 2);
			int binTwo = Integer.parseInt(bin2, 2);

			int sum = binOne + binTwo;

			answer = Integer.toBinaryString(sum);

			return answer;
		}
	}
}
