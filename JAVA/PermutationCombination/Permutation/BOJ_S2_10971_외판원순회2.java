package JAVA.PermutationCombination.Permutation;

/**
 * [BOJ] 10971. 외판원순회2 (S2)
 * @category 브루트포스, 백트래킹, 외판원 순회
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-08
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_10971_외판원순회2 {
	static int N, flag=0, min = Integer.MAX_VALUE;	// 맵크기, 방문 체크 flag, 최소 비용
	static int[][] map;
	static int[] order;					// 방문 순서
	public static void main(String[] args) throws NumberFormatException, IOException {
		// input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		order = new int[N];
		// 순열 구하기
		perm(0);
		// output
		System.out.println(min);
	}
	private static void perm(int idx) {
		// 방문 순서 정해지면 비용 구해서 최소 비용 갱신
		if (idx==N) {
			int cost = 0;
			for (int i=0; i<N; i++) {
				if (i==N-1) {
					if(map[order[i]][order[0]] == 0) return;
					cost += map[order[i]][order[0]];
				} else {
					if (map[order[i]][order[i+1]] == 0) return;
					cost += map[order[i]][order[i+1]];
				}
			}
			min = cost<min? cost : min;
			return;
		}
		// 순열
		for (int i=0; i<N; i++) {
			if ((flag&(1<<i)) != 0) continue;
			order[idx] = i;
			flag |= 1<<i;
			perm(idx+1);
			flag ^= (1<<i);
		}
	}
}
