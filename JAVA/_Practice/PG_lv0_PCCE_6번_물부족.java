package JAVA._Practice;

/**
 * [PG] PCCE. 6번 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 27.
 */
 
public class PG_lv0_PCCE_6번_물부족 {
	public static void main(String[] args){
	}

	class Solution {
		public int solution(int storage, int usage, int[] change) {
			int total_usage = 0;
			for(int i=0; i<change.length; i++){
				usage = usage + (usage * change[i]) / 100;
				total_usage += usage;
				if(total_usage > storage){
					return i;
				}
			}
			return -1;
		}
	}
}
