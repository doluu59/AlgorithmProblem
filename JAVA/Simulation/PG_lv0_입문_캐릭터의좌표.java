package JAVA.Simulation;

/**
 * [PG] 캐릭터의 좌표 | 입문 · Lv.0
 *
 * @category Simulation
 * @algorithm 2-d Coordinate Simulation
 *
 * @implNote
 * - 문제 요약   : 방향키 입력에 따라 캐릭터를 이동시키고, 보드 범위 내의 최종 좌표 반환
 * - 풀이 전략   : 각 방향에 대응하는 좌표 변화량(dx, dy)을 계산한 뒤,
 *                이동할 좌표가 보드 범위 내에 있는 경우에만 현재 좌표 갱신
 * - 시간 복잡도 : O(N) - N은 방향키 입력의 개수
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120861">캐릭터의 좌표</a>
 */
 
public class PG_lv0_입문_캐릭터의좌표 {
	static class Solution {
		static int limitX;
		static int limitY;
		public int[] solution(String[] keyinput, int[] board) {
			int[] answer = new int[2];
			limitX = board[0]/2;
			limitY = board[1]/2;

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

		boolean isValid(int x, int y) {
			return x >= limitX*(-1) && x <= limitX
							&& y >= limitY*(-1) && y <= limitY;
		}
	}
}
