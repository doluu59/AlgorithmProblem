
package JAVA._Practice;

/**
 * [PG] 입문. 다음에올숫자 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 16.
 */

public class PG_lv0_입문_다음에올숫자 {
	public static void main(String[] args){
	}

	static class Solution {
        public int solution(int[] common) {
            int answer = 0;
            if (common[1] - common[0] == common[2] - common[1]) {
              answer = common[common.length - 1] + (common[1] - common[0]);
            } else {
                answer = common[common.length - 1] * (common[1] / common[0]);
            }
            
            return answer;
        }
    }
}