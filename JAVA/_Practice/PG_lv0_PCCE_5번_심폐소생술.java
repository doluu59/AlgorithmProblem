package JAVA._Practice;

/**
 * [PG] PCCE. 5번 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 21.
 */
 
public class PG_lv0_PCCE_5번_심폐소생술 {
	public static void main(String[] args){
	}
	class Solution {
		public int[] solution(String[] cpr) {
			int[] answer = {0, 0, 0, 0, 0};
			String[] basic_order = {"check", "call", "pressure", "respiration", "repeat"};

			for(int i=0; i<cpr.length; i++){
				for(int j=0; j<basic_order.length; j++){
					if(cpr[i].equals(basic_order[j])){
						answer[i] = j+1;
						break;
					}
				}
			}
			return answer;
		}
	}
}
