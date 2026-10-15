package JAVA._Practice;

/**
 * [PG] 기초. 문자열묶기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 15.
 */
 
public class PG_lv0_기초_문자열묶기 {
	public static void main(String[] args){
	}
	class Solution {
		static final int MAX_LENGTH = 31;
		public int solution(String[] strArr) {
			int count[] = new int[MAX_LENGTH];
			for (String str : strArr) {
				count[str.length()]++;
			}

			int answer = Integer.MIN_VALUE;
			// max count
			for (int num : count) {
				if (num > answer) answer = num;
			}

			return answer;
		}
	}
}
