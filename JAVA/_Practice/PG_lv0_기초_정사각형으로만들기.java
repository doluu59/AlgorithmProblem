package JAVA._Practice;

/**
 * [PG] 기초. 정사각형으로 만들기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 9
 */

import java.util.*;

public class PG_lv0_기초_정사각형으로만들기 {
	public static void main(String[] args){
	}

	static class Solution {
        public int[][] solution(int[][] arr) {
            int max = Math.max(arr.length, arr[0].length);
            int[][] answer = new int[max][max];
            
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    answer[i][j] = arr[i][j];
                }
            }
            
            return answer;
        }
    }
}