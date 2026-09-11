package JAVA._COLLECTIONS.SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * @author 삼성 2022 하반기 오전 1번
 * @from Code Tree
 * @title 싸움땅
 * @grade G2
 * @category 시뮬레이션
 */
public class Samsung_22_2_AM_1_싸움땅 {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int N, M;
	static Map[][] map;
	static int[][] onPlayer;	// 맵에 있는 사용자 번호
	static Player[] player;
	static int[] point;			// 사용자가 얻은 포인트
	static int[] gun; 			// 사용자가 들고 있는 총
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int roundCnt = Integer.parseInt(st.nextToken());
		map = new Map[N][N];
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<N; c++) {
				map[r][c] = new Map(Integer.parseInt(st.nextToken()));
			}
		}
		// player 생성
		player = new Player[M];
		point = new int[M];
		gun = new int[M];
		int x, y, d, s;
		for (int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken())-1;
			x = Integer.parseInt(st.nextToken())-1;
			d = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			player[m] = new Player(y, x, d, s);
			map[y][x].player = m;
		}
		while (roundCnt-- > 0) {
			playRound();
		}
		String ans = "";
		for (int m=0; m<M; m++) {
			ans += point[m]+" ";
		}
		System.out.println(ans);
	}
	private static void playRound() {
		// 1-1. 한칸 이동
		int ny, nx;
		for (int i=0; i<M; i++) {
			// 움직일 좌표 선정
			ny = player[i].y + dy[player[i].dir];
			nx = player[i].x + dx[player[i].dir];
			if (!isValid(ny, nx)) { 	// 격자밖으로 나가면 반대 방향으로
				player[i].dir = (player[i].dir+2)%4;
				ny = player[i].y + dy[player[i].dir];
				nx = player[i].x + dx[player[i].dir];
			}
			// 원래 위치는 비워주기
			map[player[i].y][player[i].x].player = -1;	
			// 플레이어 이동
			player[i].y = ny;
			player[i].x = nx;
			// 2-1. 이동한 방향에 플레이어가 없는 경우 -> 가장 쎈 총 획득
			if (map[ny][nx].player == -1) {
				map[ny][nx].player = i;	// 지도에 플레이어가 자리 잡기
				if (map[ny][nx].gun.size() > 0) {		// 총이 있다면
					map[ny][nx].gun.offer(gun[i]);		// 사용자 총은 바닥에 두고
					gun[i] = map[ny][nx].gun.poll();	// 가장 쎈 총 사용자가 가져오기
				}
			} else {
			// 2-2.  이동한 방향에 플레이어가 있는 경우
				int opp = map[ny][nx].player;
				int win, lose;
				// 2-2-1. 이긴 사람이 포인트 얻기
				// 승자 판별
				if (player[i].stat+gun[i] > player[opp].stat+gun[opp]) {
					win = i; lose = opp;
				} else if (player[i].stat+gun[i] < player[opp].stat+gun[opp]) {
					win = opp; lose = i;
				} else {
					if (player[i].stat > player[opp].stat) {
						win = i; lose = opp;
					} else {
						win = opp; lose = i;
					}
				}
				// 점수 획득
				point[win] += ((player[win].stat+gun[win])-(player[lose].stat+gun[lose]));
				// 2-2-2. 진 사람은 총 내려두고, 이동하기
				// 총 바닥에 내려두기
				map[ny][nx].gun.offer(gun[lose]);	
				gun[lose] = 0;
				// 이동할 좌표 고르기
				// 원래 방향으로 한 칸 이동
				int ly = player[lose].y + dy[player[lose].dir];
				int lx = player[lose].x + dx[player[lose].dir];
				// 격자 범위 밖이거나 이동 하려는 칸에 다른 애가 있으면
				if (!isValid(ly, lx) || map[ly][lx].player!=-1) {
					int d = 3;
					while (d-- >= 0) {	// 빈 곳일 떄까지 90도 회전
						player[lose].dir = (player[lose].dir+1)%4;
						ly = player[lose].y + dy[player[lose].dir];
						lx = player[lose].x + dx[player[lose].dir];
						if (isValid(ly, lx) && map[ly][lx].player == -1) break;
					}
				}
				// 플레이어 이동
				map[ly][lx].player = lose;
				player[lose].y = ly;
				player[lose].x = lx;
				// 해당 칸에 총이 있다면
				if (map[ly][lx].gun.size() > 0) {
					// 가장 강한 총 획득
					gun[lose] = map[ly][lx].gun.poll();
				}
				// 2-2-3. 이긴 플레이어는 가장 쎈 총 갖기
				map[ny][nx].player = win;
				map[ny][nx].gun.offer(gun[win]);
				gun[win] = map[ny][nx].gun.poll();
			}
		}	// i번째 플레이어 끝
	}
	private static boolean isValid(int i, int j) {	// 격자를 벗어나지 않는지 OOB
		return i>=0 && i<N && j>=0 && j<N;
	}
	static class Player {
		int x, y, dir, stat;
		public Player(int y, int x, int dir, int stat) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.stat = stat;
		}
	}
	static class Map {
		PriorityQueue<Integer> gun;	// 현재 좌표에 놓인 총
		int player;					// 현재 좌표에 있는 플레이어
		public Map(int gun) {
			this.gun = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return -(o1-o2);	// 내림차순
				}
			});
			this.gun.offer(gun);
			this.player = -1;
		}
	}
}
