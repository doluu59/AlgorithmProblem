package JAVA.UnionFind;

/**
 * [BOJ] 10026. 적록색약 (G5)
 * @category 그래프 탐색, DFS, BFS, Union Find
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-27
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_G5_10026_적록색약 {
	static int[][] delta = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };	//4방 탐색 방향
	static int N;			//맵 크기
	static char[][] map;
	static boolean[][] isVisited;		//배열 인덱스는 i, flag의 int값은 한 행의 비트 마스킹 플래그
	static int[] colorSet;	//컬러들을 그룹으로 묶기 위함. R, G, B = 0, 1, 2 // 색약일 땐 1을 0이 바꿔 둘이 동일하게

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//input
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i=0; i<N; i++) {
			String row = br.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = row.charAt(j);
			}
		}
		// 컬러 그룹 초기화
		colorSet = new int[3];
		for (int i=0; i<3; i++) {
			colorSet[i] = i;
		}
		//적록 색약 X, O 한번 씩
		for (int n=0; n<2; n++) {
			isVisited = new boolean[N][N];				// 플래그 초기화
			int areaCnt=0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (!isVisited[i][j]) {	//아직 방문 하지 않았다면
						dfs(i, j);
						areaCnt++;			//구역 하나 다 탐색했으면 구역 수++
					}
				}
			}
			sb.append(areaCnt+" ");
			// union 역할 => Green을 Red와 같은 애로 인식
			colorSet[1]=colorSet[0];
		}
		System.out.println(sb);
		br.close();
	}
	private static void dfs(int i, int j) {
		isVisited[i][j] = true;	//방문 처리

		for (int di=0; di<4; di++) {
			int ni = i+delta[di][0];
			int nj = j+delta[di][1];
			if (	isValid(ni, nj) && 			//맵 안벗어나고
							(!isVisited[ni][nj]) &&		//방문 안했고
							findColorGroup(map[i][j])==findColorGroup(map[ni][nj]) ) {	//같은 컬러 그룹이면 dfs 방문
				dfs(ni, nj);
			}
		}
	}
	//oob
	private static boolean isValid(int ni, int nj) {
		return ni>=0 && ni<N && nj>=0 && nj<N;
	}
	// 컬러에 따라 컬러 그룹 (색약일 경우 R과 G가 같은 컬러 그룹)으로
	private static int findColorGroup(char color) {
		switch(color) {
			case 'R':
				return colorSet[0];
			case 'G':
				return colorSet[1];
			case 'B':
				return colorSet[2];
			default:
				return -1;
		}
	}
}
