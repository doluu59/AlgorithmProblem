package JAVA.Search.DFSnBFS.BFS;

/**
 * [BOJ] 14502. 연구소 (G4)
 * @category 구현, 조합, 브루트포스, 그래프 탐색, BFS
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-10
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_14502_연구소 {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int N, M, maxSafteyArea = Integer.MIN_VALUE;
	static int[][] map, tmap;
	static long flag;
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tmap = new int[N][M];
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		// 64C3
		comb(0, 0);
		// output
		System.out.println(maxSafteyArea);
	}
	private static void comb(int cnt, int idx) {
		if (cnt==3) {
			// 맵 복사 (벽 생성된 Map을 Temp Map에 저장 -> 바이러스 퍼트리기 위함
			copyMap();
			int safetyArea = 0;
			flag = 0;
			// 바이러스 퍼트리기 (BFS)
			for (int n=0; n<N; n++) {
				for (int m=0; m<M; m++) {
					if (tmap[n][m]==2) bfs(n, m);	//
				}
			}
			// 안전 구역 세기
			for (int n=0; n<N; n++) {
				for (int m=0; m<M; m++) {
					if(tmap[n][m]==0) safetyArea++;
				}
			}
			// 안전 구역 최대값 갱신
			maxSafteyArea = Math.max(maxSafteyArea, safetyArea);
			return;
		}
		if (idx==N*M) return;	// 가지치기 종료 조건
		// 가지치기로 조합
		comb(cnt, idx+1);
		if (map[idx/M][idx%M]==0) {
			map[idx/M][idx%M] = 1;
			comb(cnt+1, idx+1);
			map[idx/M][idx%M] = 0;
		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { i, j });
		flag |= 1<<(M*i+j);
		// bfs
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curi = cur[0], curj = cur[1];
			for (int d=0;d<4; d++) {		// 4-way search
				int ni = curi+dy[d], nj = curj+dx[d];
				if (isValid(ni, nj) && tmap[ni][nj]==0) {	// 바이러스가 퍼질 수 있는 곳이면
					flag |= ((long)1<<(M*ni+nj));
					tmap[ni][nj] = 2;
					queue.offer(new int[] {ni, nj});
				}
			}
		}
	}
	// Copy Values of Map
	private static void copyMap() {
		for (int n=0; n<N; n++) {
			for (int m=0; m<M; m++) {
				tmap[n][m] = map[n][m];
			}
		}
	}
	// Out of Bound
	private static boolean isValid(int i, int j) {
		return i>=0 && i<N && j>=0 && j<M;
	}
}
