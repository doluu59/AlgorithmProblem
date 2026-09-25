package JAVA.PermutationCombination.Permutation;

/**
 * [SWEA] 5656. 벽돌깨기 (모의)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-12
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_모의_5656_벽돌깨기 {
	static int N, W, H;
	static int[][] map;
	static int[] order;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			for (int h=0; h<H; h++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int w=0; w<W; w++) {
					map[h][w] = Integer.parseInt(st.nextToken());
				}
			}

			order = new int[W];
			// 구슬의 위치는 N! 순열
			perm(0);
			//
		}

	}
	private static void perm(int cnt) {
		if (cnt==N) {
			int[][] temp = copy(map);
			for (int n=0; n<N; n++) {
				int w = order[n];
				int h = -1;
				for (int i=0; i<H; i++ ) {
					if (temp[i][w] != 0) {
						h = i;
						break;
					}
				}
				if (h==-1) continue;
				bomb(h, w, temp);

				//터트린 후 남은 애들 바닥에 붙여야 함.

				System.out.println("n: "+n);
				System.out.println("order: "+order[n]);
				for (int i=0; i<H; i++) {
					System.out.println(Arrays.toString(temp[i]));
				}

			}
			return;
		}
		for (int i=0; i<W; i++) {
			order[cnt] = i;
			perm(cnt+1);
		}
	}
	private static void bomb(int i, int j, int[][] map) {
		if (!isValid(i, j)) return;
		if (map[i][j] == 0) return;
		if (map[i][j] == 1) {
			map[i][j] = 0; return;
		}
		if (map[i][j] > 1) {
			for (int n=1; n<map[i][j]; n++) {
				//범위 안에 속하는 애들 다 터트리기
				bomb(i+n*(-1), j, map);
				bomb(i+n*1, j, map);
				bomb(i, j+n*(-1), map);
				bomb(i, j+n*1, map);
			}
		}
	}
	private static boolean isValid(int i, int j) {

		return i>=0 && i<H && j>=0 && j<W;
	}
	private static int[][] copy(int[][] map) {
		int[][] temp = new int[H][W];
		for (int i=0; i<H; i++) {
			temp[i] = map[i].clone();
		}
		return temp;
	}
}
