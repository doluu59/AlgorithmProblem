package JAVA._COLLECTIONS.KAKAO._25.하반기_2차;

/**
 * [PG] KAKAO. 2025하반기2차 (lv2)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : Sliding Window - Deque
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 11.
 */

import java.util.*;

public class PG_lv2_KAKAO_2025하반기2차_선인장숨기기 {
	public static void main(String[] args){

	}

	class Solution {
		int[][] map;
		int m, n, h, w;
		static final int INF = Integer.MAX_VALUE;

		public int[] solution(int M, int N, int H, int W, int[][] drops) {
			// input
			m = M; n=N; h=H; w=W;
			int[] answer = new int[2];
			map = new int[m][n];
			for (int i=0; i<m; i++) {
				Arrays.fill(map[i], INF);
			}

			// Rain Drop
			for (int i=0; i<drops.length; i++) {
				map[drops[i][0]][drops[i][1]] = i+1;
			}

			// print test
			// for (int i=0; i<m; i++) {
			//     for (int j=0; j<n; j++) {
			//         System.out.print(map[i][j]);
			//     }
			//     System.out.println();
			// }

			// 가로 슬라이딩 윈도우
			int[][] rowSliding = new int[m][n-w+1];

			for (int i=0; i<m; i++) {
				// Sliding Window
				Deque<Integer> deque = new ArrayDeque<>();
				for (int j=0; j<n; j++) {
					int cur = map[i][j];

					// 1. Deque에 오름차순으로 남겨놓기
					// 현재 값보다 큰 이전의 아이템들은 제거
					// -> 나보다 윈도우크기 먼저 벗어나지만, 최소값일 가능성은 없으니
					while (!deque.isEmpty()) {
						int lastCol = deque.peekLast();
						if (cur <= map[i][lastCol]) deque.pollLast();
						else break;
					}

					// 2. 최솟값이 범위를 벗어난 거면 제거
					deque.offerLast(j);
					if (deque.peekFirst() < j-w+1) deque.pollFirst();

					// slidingWindow 업데이트
					if (j-w+1 >= 0) {
						int minCol = deque.peekFirst();
						rowSliding[i][j-w+1] = map[i][minCol];
					}
				}
			}

			//print test
			// for (int i=0; i<m; i++) {
			//     for (int j=0; j<n-w+1; j++) {
			//         System.out.print(rowSliding[i][j]+" ");
			//     }
			//     System.out.println();
			// }

			// 세로 슬라이딩 윈도우
			int[][] colSliding = new int[m-h+1][n-w+1];
			for (int j=0; j<n-w+1; j++) {
				Deque<Integer> deque = new ArrayDeque<>();
				// 1.
				for (int i=0; i<m; i++) {
					int cur = rowSliding[i][j];

					while (!deque.isEmpty()) {
						int lastRow = deque.peekLast();
						if (cur <= rowSliding[lastRow][j]) deque.pollLast();
						else break;
					}

					// 현재 값 덱에 넣기
					deque.offerLast(i);

					// 2. 범위 벗어난 최솟값 제거
					if (deque.peekFirst() < i-h+1) deque.pollFirst();

					// 3. Update Sliding Window
					if (i-h+1 >= 0) {
						int minRow = deque.peekFirst();
						colSliding[i-h+1][j] = rowSliding[minRow][j];
					}
				}
			}

			// print test
			// System.out.println();
			// for (int i=0; i<m-h+1; i++) {
			//     for (int j=0; j<n-w+1; j++) {
			//         System.out.print(colSliding[i][j]+" ");
			//     }
			//     System.out.println();
			// }

			int max = Integer.MIN_VALUE;

			// output
			for (int i=0; i<m-h+1; i++) {
				for (int j=0; j<n-w+1; j++) {
					int time = colSliding[i][j];
					if (time == INF) {
						answer[0] = i; answer[1] = j;
						return answer;
					}
					if (time > max) {
						answer[0] = i; answer[1] = j;
						max = time;
					}
				}
			}

			return answer;

			// 선인장 - sliding window
			// drops 좌표들마다 그냥 해당 좌표를 다 인덱스 저장하면???
			// 시작점부터 돌면서, 닿는 빗방울의 최소 값 저장
			// 슬라이딩 윈도우의 최대값보다 크면 개선
			// 돌면서 내 윈도우에 아무 것도 없거나, 젤 큰 숫자가 있는 거?
		}
	}
}
