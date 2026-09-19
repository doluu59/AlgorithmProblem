package JAVA._Practice;

/**
 * [PG] 기초. 커피심부름 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 5.
 */
 
public class PG_lv0_기초_커피심부름 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(String[] order) {
			int answer = 0;
			for (int i = 0; i < order.length; i++) {
				if (order[i].contains("cafelatte")) {
					answer += 5000;
				} else {
					answer += 4500;
				}
			}
			return answer;
		}
	}
}
