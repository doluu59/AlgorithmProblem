package JAVA.Hash.Map;

/**
 * [PG] 입문. 최빈값구하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 17.
 */

import java.util.*;

public class PG_lv0_입문_최빈값구하기 {
	public static void main(String[] args){
	}

	static class Solution {
        public int solution(int[] array) {
            int maxCount = 0;
            int answer = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for(int number : array){
                int count = map.getOrDefault(number, 0) + 1;
                if(count > maxCount){
                    maxCount = count;
                    answer = number;
                } else if(count == maxCount){
                    answer = -1;
                }
                map.put(number, count);
            }
            return answer;
        }
    }
}