package JAVA;

/**
 * [PG] 입문. 캐릭터의좌표 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 5.
 */
 
public class PG_lv0_입문_캐릭터의좌표 {
	public static void main(String[] args){
	}

	static class Solution {
		static int[] border = new int[4];
		public int[] solution(String[] keyinput, int[] board) {
			int[] answer = new int[2];

			border[0] = board[0]/2;
			border[1] = board[0]/2 * (-1);
			border[2] = board[1]/2;
			border[3] = board[1]/2 * (-1);

			for (String input : keyinput) {
				int[] delta = move(input);
				if (!isValid(answer[0] + delta[0], answer[1] + delta[1])) continue;

				answer[0] += delta[0];
				answer[1] += delta[1];
			}
			return answer;
		}

		int[] move (String input) {
			int[] delta = new int[2];
			switch (input) {
				case "left":
					delta[0] = -1;
					break;
				case "right":
					delta[0] = 1;
					break;
				case "up":
					delta[1] = 1;
					break;
				default:
					delta[1] = -1;
					break;
			}

			return delta;
		}

		boolean isValid(int i, int j) {
			return i >= border[1] && i <= border[0] && j >= border[3] && j <= border[2];
		}
	}
}
