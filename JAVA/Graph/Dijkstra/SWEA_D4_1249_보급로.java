package JAVA.Graph.Dijkstra;

/**
 * [SWEA] 1249. 보급로 (D4)
 * @category 다익스트라
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-13
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SWEA_D4_1249_보급로 {
	static int N, map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc=1; tc<=TC; tc++) {
			// input
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i=0; i<N; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j=0; j<N; j++) {
					map[i][j] = ch[j] - '0';
				}
			}
			//output
			System.out.println("#"+tc+" "+dijkstra());
		}

	}

	private static int dijkstra() {
		final int INF  = Integer.MAX_VALUE;
		// 이 좌표까지 오는 최소 비용
		int[][] minTime = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		// PQ
		PriorityQueue<int[]> pq = new PriorityQueue<>( new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});	// 정점 좌표랑 비용 -> 클래스나 배열
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				minTime[i][j] = INF;
			}
		}

		//출발지 설정
		minTime[0][0] = 0;
		pq.offer( new int[] {0, 0, minTime[0][0]} );

		int[] cur = null;
		int r, c, minCost;
		while (!pq.isEmpty()) {
			// step 1
			cur = pq.poll();
			r = cur[0]; c = cur[1]; minCost = cur[2];

			// 미리 계산됐을 수 있기 때문에 불필요한 연산이 일어남 (값은 안바뀜)
			if (visited[r][c]) continue;	//***
			visited[r][c] = true;	//방문 처리
			if (r==N-1 && c==N-1) return minCost;	//도착지 오면 끝내버리기

			// step2
			int nr=0, nc=0;
			for (int d=0; d<4; d++) {
				nr = r + dr[d]; nc = c + dc[d];
				if (isValid(nr, nc) && !visited[nr][nc]
								&& minTime[nr][nc] > minCost + map[nr][nc]) {
					minTime[nr][nc] = minCost + map[nr][nc];		// update
					pq.offer(new int[] {nr, nc, minTime[nr][nc]});	// enqueue
				}
			}
		}
		// PQ 다 돌렸는데 정답을 못찾았다면 ?? => 그런 경우는 없긴 하네
		return -1;
	}
	private static boolean isValid(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
