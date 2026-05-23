package JAVA.Search.DFSnBFS;

/**
 * [BOJ] 1987. 알파벳 (G4)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-22
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_1987_알파벳 {
	static int[][] delta = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };	//4방 탐색 위한 델타 **재귀등에서 여러번 생성하는 게 더 오래 걸림
	static int R, C;												// R*C 맵
	static char[][] map;											// 입력으로 받는 맵
	static int max=Integer.MIN_VALUE;								// 말이 지날 수 있는 최대 칸
	static int alphaFlag;	// 좌표에 있는 알파벳이 사용되었는지 비트 마스킹 플래그 ** 얘가 visited 역할도 함
	static int dfsCnt;												// dfs가 몇번 탐색했는지 (이게 업데이트 되면서 최대값 찾기)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// input
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		dfsCnt=0;
		for (int i=0; i<R; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j=0; j<C; j++) {
				map[i][j] = row[j];
			}
		}
		// dfs
		dfs(0, 0);
		// output
		System.out.println(max);
	}
	private static void dfs(int i, int j) {
		// 해당 좌표를 탐색 헀을 때
		alphaFlag |= 1<<(int)(map[i][j]-'A');	// 해당 좌표에 있는 알파벳 사용 체크
		dfsCnt++;								// 탐색 횟수 증가
		if (dfsCnt>max) max = dfsCnt;			// 최대 값 갱신
		//4방 탐색 우, 하, 좌, 상 순서
		for (int d=0; d<4; d++) {

			//좌표 수정하기
			int ni=i+delta[d][0];
			int nj=j+delta[d][1];
			//맵 경계선 안나가가과, 알파벳 사용 안했고, 방문 안 좌표 일 때만 탐색 가능
			if (isValid(ni, nj) && (alphaFlag & 1<<(int)(map[ni][nj]-'A')) == 0) {
				dfs(ni, nj);
				//dfs 탐색이 끝났으면 내가 썼던 전역 변수 되돌리기 (다른 애들한테 영향 안받게)
				alphaFlag &= ~(1<<(int)(map[ni][nj]-'A'));
				dfsCnt--;
			}
		}
	}
	private static boolean isValid(int i, int j) {
		return i>=0 && i<R && j>=0 && j<C;
	}
}
