package JAVA.Search.DFSnBFS.BFS;

/**
 * [BOJ] 7569. 토마토 (G5)
 * @category BFS
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-01
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_7569_토마토 {
	static class Tomato {
		int h, i, j, day;
		public Tomato(int h, int i, int j, int day) {
			super();
			this.h = h;
			this.i = i;
			this.j = j;
			this.day = day;
		}
	}
	static int[] dh = { 1, -1, 0, 0, 0, 0 };	// 위, 아래
	static int[] di = {0, 0, 1, -1, 0, 0 };		// 앞, 뒤
	static int[] dj = { 0, 0, 0, 0, 1, -1 };
	static int H, M, N;
	static int[][][] tomato;
	static int tomatoCnt=0;
	static Queue<Tomato> queue = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomato = new int[H][N][M];	// -1은 토마토 X, 0: 안 익은 토마토, 1: 익은 토마토
		for (int h=0; h<H; h++) {
			for (int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int m=0; m<M; m++) {
					tomato[h][n][m] = Integer.parseInt(st.nextToken());
					// 토마토 익히기
					if (tomato[h][n][m]==1) {
						queue.offer(new Tomato(h, n, m, 0));	// 처음에 익어있는 토마토를 큐에 넣어놓고, 이후엔 그 영향 받는 애들만 처리
					}
					// 토마토 총 개수
					if (tomato[h][n][m] != -1) {
						++tomatoCnt;
					}
				}
			}
		}

		System.out.println(ripeTomato(queue));
	}
	//큐에 들은 토마토들 주위를 익혀버리기
	private static int ripeTomato(Queue<Tomato> queue) {
		int days = -1;
		while(!queue.isEmpty()) {
			Tomato cur = queue.poll();
			days = cur.day;
			int h=cur.h, n=cur.i, m=cur.j;
			tomato[h][n][m] = -1;	//다른 애들 익게 했다.
			tomatoCnt--;	//토마토 익으면 총 개수에서 제거

			//주위 토마토 익히기
			int nh, ni, nj;
			for (int d=0; d<6; d++) {
				nh = h + dh[d]; ni = n + di[d]; nj = m + dj[d];
				if (isValid(nh, ni, nj) && tomato[nh][ni][nj] == 0) {
					// 이번 일자에 새로 익은 애들은 방문처리를 true로 해두고 다른 애 영향 안주게
					tomato[nh][ni][nj] = 1;
					// 얘네만 토마토에 넣기
					queue.offer(new Tomato(nh, ni, nj, cur.day+1));
					//
				}
			}
		}
		// BFS 끝난 후, 처리 안한 토마토 남아있으면 -1
		if (tomatoCnt > 0) return -1;
		else return days;

	}
	private static boolean isValid(int nh, int ni, int nj) {
		return nh>=0 && nh<H && ni>=0 && ni<N && nj>=0 && nj<M;
	}
}
