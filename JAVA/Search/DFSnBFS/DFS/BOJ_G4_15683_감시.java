package JAVA.Search.DFSnBFS.DFS;

/**
 * [BOJ] 15683. 감시 (G4)
 * @category DFS / Back Tracking
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-26
 */

import java.util.*;
import java.io.*;

public class BOJ_G4_15683_감시 {
	static int[][] delta = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} }; //상우하좌

	static List<CCTV> cctvs;
	static int N, M, min=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] office = new int[N][M];
		cctvs = new ArrayList<>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());	//맵
				if (office[i][j] !=0 && office[i][j] != 6) {
					cctvs.add(new CCTV(i, j, office[i][j]));		//cctv 리스트에 추가
				} else if (office[i][j]==0) min++;
			}
		}
		if (cctvs.size()!=0) turnOnCCTV(0, office);	//cctv 있을 때만

		System.out.println(min);
	}
	//재귀 호출로 cctv를 하나씩 방향 별로 가능한 경우를 만들 때마다 다음 cctv를 재귀 호출
	static void turnOnCCTV(int curIdx, int[][] originalmap) {
		//사각지대 count
		if (curIdx==cctvs.size()) {
			int curCount = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (originalmap[i][j]==0) curCount++;
				}
			}
			min = curCount<min?curCount:min;	//최소값 갱신
			return;
		}
		// 현재 cctv에서 가능한 방향을 모두 만들어보기
		CCTV cur = cctvs.get(curIdx);				//cctv 리스트에서 꺼낸 이번 cctv
		for (int di=0; di<cur.getRotCnt(); di++) { 	//cctv 타입에 따라 가능한 방향의 개수가 다르기 때문에 반복 횟수 다름
			int[][] tempmap = copy(originalmap);	//자바는 왜 deep copy가 안되냐 진짜;;;;
			switch(cur.type) {
				case 1:
					switchOn(cur, di, tempmap);
					break;
				case 2:
					switchOn(cur, di, tempmap);		//0이면 상, 1이면 우
					switchOn(cur, di+2, tempmap);	//0이면 하, 1이면 좌
					break;
				case 3:
					switchOn(cur, di, tempmap);			//0,1,2,3 - 상우하좌
					switchOn(cur, (di+1)%4, tempmap);	//1,2,3,0 - 우하좌상
					break;
				case 4:
					for (int i=0; i<4; i++) {
						if (i!=di) switchOn(cur, i, tempmap);	//di 방향 뺴고 나머지 3방향 켜기
					}
					break;
				case 5:
					for (int i=0; i<4; i++) {
						switchOn(cur, i, tempmap);
					}
					break;
				default:
					break;
			}
			turnOnCCTV(curIdx+1, tempmap);
		}
	}
	//이차원 배열 temp 생성
	private static int[][] copy(int[][] map) {
		int[][] tempmap = new int[N][M];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				tempmap[i][j] = map[i][j];
			}
		}
		return tempmap;
	}
	//4방향 중 정한 di 방향으로 쭉 감시 하는 지역 바꾸기
	private static void switchOn(CCTV cur, int di, int[][] temp) {
		//정한 델타 방향으로 현재 cctv 좌표에서 감시하기
		int ni = cur.y+delta[di][0];
		int nj = cur.x+delta[di][1];
		while (isValid(ni, nj)) {	//맵 안나가는 동안 반복
			switch(temp[ni][nj]) {
				case 6:									//벽
					return;
				case 1: case 2: case 3: case 4: case 5:	//cctv는 통과
					break;
				default: 								//벽 아닌 경우
					temp[ni][nj]=-1;
					break;
			}
			//다음 반복을 위한 재귀 갱신
			ni += delta[di][0];
			nj += delta[di][1];
		}
	}
	// OutOfBounds check
	private static boolean isValid(int ni, int nj) {
		return ni>=0 && ni<N && nj>=0 && nj<M;
	}
	// CCTV 객체
	static class CCTV {
		int y; int x;
		int type;
		public CCTV(int y, int x, int type) {
			this.y = y;
			this.x = x;
			this.type = type;
		}
		//회전할 수 있는 방향의 수
		public int getRotCnt() {
			switch (this.type) {
				case 1:
					return 4;
				case 2:
					return 2;
				case 3:
					return 4;
				case 4:
					return 4;
				case 5:
					return 1;
				default:
					return -1;
			}
		}
	}
}
