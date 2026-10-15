package JAVA._Practice;

/**
 * [PG] 입문. 직사각형넓이구하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 1.
 */
 
public class PG_lv0_입문_직사각형넓이구하기 {
	public static void main(String[] args){
	}
	static class Solution {
		public int solution(int[][] dots) {
			int answer = 0;
			int[] x = new int[2];
			int[] y = new int[2];

			x[0] = dots[0][0]; y[0] = dots[0][1];
			for (int[] dot : dots) {
				if (dot[0] != x[0]) x[1] = dot[0];
				if (dot[1] != y[0]) y[1] = dot[1];
			}

			answer = Math.abs(x[1] - x[0]) * Math.abs(y[1] - y[0]); // width * height
			return answer;
		}
	}
}
