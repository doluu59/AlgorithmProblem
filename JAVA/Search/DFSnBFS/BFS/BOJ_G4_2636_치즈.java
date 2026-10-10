package JAVA.Search.DFSnBFS.BFS;

/**
 * [BOJ] 2636. 치즈 (G4)
 * @category 구현, 시뮬레이션, 그래프 탐색, BFS
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-11
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_2636_치즈 {
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		boolean[][] visited;
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		// solve
		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, -1, 0, 1 };
		int time = 0;
		int cheese = 0;
		while(true) {
			int cnt = count();	// 1개수 세기
			if (cnt == 0) break;
			else cheese = cnt;
			// 치즈 녹이기
			time++;
			// 0에서 출발하는 BFS로 0-> 공기, 1-> 공기에 닿는 치즈
			Queue<Pos> queue = new ArrayDeque<>();
			visited = new boolean[N][M];
			// 공기 출발점
			queue.offer(new Pos(0, 0));
			visited[0][0] = true;
			// 공기, 공기와 닿는 경계면 탐색
			while(!queue.isEmpty()) {
				Pos cur = queue.poll();
				for (int d=0; d<4; d++) {
					int nr = cur.r+dy[d], nc = cur.c+dx[d];
					// 공기면 탐색에 추가. 공기와 닿는 치즈는 2로 체크
					if (isValid(nr, nc)) {
						switch(map[nr][nc]) {
							case 0:
								if (!visited[nr][nc]) {
									visited[nr][nc] = true;
									queue.offer(new Pos(nr, nc));
								}
								break;
							case 1:
								map[nr][nc] = 2;
								break;
						}
					}
				}
			}
			// 2로 바꿔둔 공기와 닿는 치즈 녹이기
			melt();
		}
		// output
		System.out.printf(time+"\n"+cheese+"\n");
	}
	private static boolean isValid(int nr, int nc) {
		return  nr>=0 && nr<N && nc>=0 && nc<M;
	}
	private static void melt() {
		for (int n=0; n<N; n++) {
			for (int m=0; m<M; m++) {
				if(map[n][m]==2) map[n][m]=0;
			}
		}
	}
	private static int count() {
		int cnt = 0;
		for (int n=0; n<N; n++) {
			for (int m=0; m<M; m++) {
				if(map[n][m]==1) cnt++;
			}
		}
		return cnt;
	}
	static class Pos {
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
