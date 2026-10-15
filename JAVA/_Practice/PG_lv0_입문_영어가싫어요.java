package JAVA._Practice;

/**
 * [PG] 입문. 영어가싫어요 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 7.
 */
 
public class PG_lv0_입문_영어가싫어요 {
	public static void main(String[] args){
	}
	static class Solution {
		public long solution(String numbers) {
			String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
			StringBuilder result = new StringBuilder();

			while (!numbers.isEmpty()) {
				for (int i = 0; i < num.length; i++) {
					if (numbers.startsWith(num[i])) {
						result.append(i);
						numbers = numbers.substring(num[i].length());
						break;
					}
				}
			}

			return Long.parseLong(result.toString());
		}
	}
}
