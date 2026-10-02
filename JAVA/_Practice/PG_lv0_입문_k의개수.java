package JAVA._Practice;

/**
 * [PG] 입문. k의개수 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 4.
 */
 
public class PG_lv0_입문_k의개수 {
	class Solution {
		public int solution(int i, int j, int k) {
			int answer = 0;
			String kk = String.valueOf(k);
			for(int f=i; f <= j; f++){
				String val = String.valueOf(f);
				if(val.contains(kk)){
					String[] arr = val.split("");
					for(String ttl : arr){
						if(ttl.equals(kk))answer++;
					}
				}
			}
			return answer;
		}
	}
}
