package JAVA._COLLECTIONS.SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @author 삼성 2022 상반기 오전 2번
 * @from Code Tree
 * @title 예술성
 * @grade G3
 * @category 시뮬레이션, BFS, DFS, 조합, Devide&Conquer
 */
public class Samsung_22_1_AM_2_예술성 {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int[][] map;			// 현재 좌표의 숫자
	static int[][] groupIdx;	// 현재 좌표의 그룹 번호
	static int N, center, ans;
	// 그룹 단위
	static Group[] group;		// 그룹이 가진 정보를 표현하기 위함.
	static int[][] adjCnt;		// 두 그룹 간의 인접한 변의 개수
	// 조합
	static int[] combi;			// 조화 점수를 구하기 위한 두 그룹 조합으로 선별
	static class Pos {
		int i, j;
		public Pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static class Group {
		int count, value;	// 그룹에 해당하는 칸의 수, 그룹의 실제 숫자
		public Group(int value) {
			this.count = 0;
			this.value = value;
		}
	}
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		center = N/2;
		ans = 0;
		map = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// solve
		for (int rotation=0; rotation<4; rotation++) {
			groupIdx = new int[N][N];
			int groupCnt = 0;
			// 1. 예술 점수 구하기
			// 	1.1. 그룹 만들기 - 모든 점에서 출발하는 BFS를 돌림
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (groupIdx[i][j] == 0) {			// 그룹 번호 지정 안된 상태면
						devideGroup(++groupCnt, i, j);	// 그룹 번호 지정 후, 인접한 곳을 같은 수를 가진 곳을 같은 그룹으로 묶기
					}
				}
			}
			//	1.2. 각 그룹마다 각 그룹의 칸 수, 숫자 값 세기
			group = new Group[groupCnt+1];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					// 그룹에 실제 숫자 값이 지정 안되어 있으면 그룹 생성하고, 현재 좌표가 속한 그룹에 실제 숫자 값 지정
					if (group[groupIdx[i][j]]==null) group[groupIdx[i][j]] = new Group(map[i][j]);
					group[groupIdx[i][j]].count++;	// 현재 좌표가 속한 그룹에 속한 칸의 수 증가
				}
			}
			//	1.3. 인접한 그룹 간의 변 세기
			adjCnt = new int[groupCnt+1][groupCnt+1];
			groupAdjCnt(groupCnt);
			// 	1.4. 첫 그룹~마지막 그룹 중 2가지 그룹을 골라서 두 그룹의 조화 점수 구하기 (조합)
			combi = new int[2];
			comb(1, 0);
			// 2. 회전
			if (rotation==3) break;
			rotate();
		}
		// 정답 출력
		System.out.println(ans);
	}
	// 1.1 같은 그룹끼리 묶기 - BFS
	private static void devideGroup(int g, int si, int sj) {	// 모든 좌표가 몇번 그룹에 속해있는지 저장
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(si, sj));
		groupIdx[si][sj] = g;	// 방문체크 겸 그룹 지정
		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			for (int d=0; d<4; d++) {
				int ni = cur.i + dy[d];
				int nj = cur.j + dx[d];
				if (!isValidPos(ni, nj)) continue;		// oob
				if (groupIdx[ni][nj] == g) continue;	// 방문해서 이미 그룹 정했으면 탈출
				if (map[si][sj] == map[ni][nj]) {		// 같은 숫자면 같은 그룹으로 지정, 탐색 계속
					groupIdx[ni][nj] = g;
					queue.offer(new Pos(ni, nj));
				}
			}
		}
	}
	// 1.3 인접한 그룹 간의 변의 개수 세기 - BFS
	private static void groupAdjCnt(int groupCnt) {
		boolean[][] visited = new boolean[N][N];
		Queue<Pos> queue = null;
		// 모든 점에서 출발하는 bfs
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (visited[i][j]) continue;
				// bfs
				queue = new ArrayDeque<>();
				queue.offer(new Pos(i, j));
				visited[i][j] = true;
				while (!queue.isEmpty()) {	// 더 이상 같은 그룹 없으면 종료
					Pos cur = queue.poll();
					for (int d=0; d<4; d++) {	// 현재 좌표에서 인접 4방 탐색
						int ni = cur.i + dy[d];
						int nj = cur.j + dx[d];
						if (!isValidPos(ni, nj)) continue;	// 맵 벗어남 (oob)
						if (visited[ni][nj]) continue;		// 이미 전에나 현재 체크한 그룹이면 넘어감
						if (groupIdx[ni][nj] == groupIdx[i][j]) {			// 같은 그룹이면 탐색 계속
							visited[ni][nj] = true;
							queue.offer(new Pos(ni, nj));
						} else adjCnt[groupIdx[i][j]][groupIdx[ni][nj]]++;	// 인접한 두 좌표가 다른 그룹이면 두 그룹 간의 연결된 변의 수 증가
					}
				}
			}
		}
	}
	// 1.4 조화 점수를 구하기 위해 두 그룹 고르기 (조합)
	private static void comb(int idx, int cnt) {
		// 그룹 두개 뽑아서 두 그룹 간의 조화 점수 구하기
		if (cnt == 2) {	
			int g1 = combi[0], g2 = combi[1];
			ans += (group[g1].count+group[g2].count) * group[g1].value * group[g2].value * adjCnt[g1][g2];
			return;
		}
		// 조합 구하기
		for (int i=idx; i<group.length; i++) {
			combi[cnt] = i;
			comb(i+1, cnt+1);
		}
	}
	// 2. 회전 시키기
	private static void rotate() {
		// 2.1 십자가 회전
		Queue<Integer>[] queue = new ArrayDeque[2];
		queue[0] = new ArrayDeque<>();
		queue[1] = new ArrayDeque<>();
		for (int n=0; n<N; n++) {
			if (n==center) continue;
			queue[0].offer(map[n][center]);			//세로줄 추출
			queue[1].offer(map[center][n]);			//가로줄 추출
		}
		for (int n=0; n<N; n++) {
			if (n==center) continue;
			map[center][n] = queue[0].poll();		// 세로줄 추출한 것 가로줄로 넣기
			map[N-1-n][center] = queue[1].poll();	// 가로줄 추출한 것 세로줄로 넣기
		}
		// 2.2 작은 네모 회전 - 시작 좌표값과, 크기 받아서 devide & conquer
		rotateBox(0, 0);
		rotateBox(center+1, 0);
		rotateBox(0, center+1);
		rotateBox(center+1, center+1);
	}
	// 2.2 작은 네모 회전
	private static void rotateBox(int si, int sj) {
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i=0; i<center; i++) {
			for (int j=0; j<center; j++) {
				queue.offer(map[si+i][sj+j]);
			}
		}
		// 시계 방향 회전 했을 때의 변하는 좌표로 변경
		for (int j=center-1; j>=0; j--) {
			for (int i=0; i<center; i++) {
				map[si+i][sj+j] = queue.poll();
			}
		}
	}
	// oob
	private static boolean isValidPos(int i, int j) {
		return i>=0 && i<N && j>=0 && j<N;
	}
}