package JAVA._Practice;

/**
 * [PG] 입문. 외계어사전 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 10.
 */
 
public class PG_lv0_입문_외계어사전 {
	public static void main(String[] args){
	}
	static class Solution {
		public int solution(String[] spell, String[] dic) {
			int answer = 2; int index = 0;

			for(int i = 0; i < dic.length; i++) {
				index = 0;
				for(int j = 0; j < spell.length; j++) {
					if(dic[i].contains(spell[j])) index++;
					if(index == spell.length) answer = 1;
				}
			}

			return answer;
		}
	}
}
