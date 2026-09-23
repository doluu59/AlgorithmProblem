package JAVA._Practice;

/**
 * [PG] 기초. 6번 (lv0)
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
 
public class PG_lv0_기초_6번_가채점 {
	public static void main(String[] args){
	}

	class Solution {
		public String[] solution(int[] numbers, int[] our_score, int[] score_list) {
			int num_student = numbers.length;
			String[] answer = new String[num_student];

			for (int i = 0; i < num_student; i++) {
				if (our_score[i] == score_list[numbers[i]-1]) {
					answer[i] = "Same";
				}
				else {
					answer[i] = "Different";
				}
			}

			return answer;
		}
	}
}
