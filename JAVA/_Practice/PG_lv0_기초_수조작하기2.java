package JAVA._Practice;

/**
 * [PG] 기초. 수조작하기2 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 8.
 */
 
public class PG_lv0_기초_수조작하기2 {
	public static void main(String[] args){
	}
	class Solution {
		public String solution(int[] numLog) {
			int[] arr = new int[numLog.length-1];
			for (int i=1; i<numLog.length; i++) {
				arr[i-1] = numLog[i]- numLog[i-1];
			}
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<arr.length; i++) {
				switch (arr[i]) {
					case 1:
						sb.append("w");
						break;
					case -1:
						sb.append("s");
						break;
					case 10:
						sb.append("d");
						break;
					case -10:
						sb.append("a");
						break;
				}
			}
			return sb.toString();
		}
	}
}
