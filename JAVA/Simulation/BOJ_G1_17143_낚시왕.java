package JAVA.Simulation;

/**
 * [BOJ] 17143. 낚시왕 (G1)
 * @category Implementation / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-31
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_G1_17143_낚시왕 {
	static int[][] delta = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
	static int R, C;			//map size, 상어 수
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Shark[] sharks = new Shark[M+1];
		int[][] map = new int[R+1][C+1];
		for(int m=1; m<=M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			sharks[m] = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
			map[sharks[m].r][sharks[m].c] = m;
		}

		int size = 0;
		for (int c = 1; c <= C; c++) { 	// step1. 낚시왕이 1부터 C까지 이동
			// step2. 낚시왕이 있는 C 중에서 땅과 가장 가까운 상어 잡아
			for (int r=1; r<=R; r++) {
				if (map[r][c] != 0) {
					int target = map[r][c];
					size+=sharks[target].size;
					map[r][c] = 0;
					sharks[target] = null;
					break;
				}
			}
			// step 3. 상어 이동
			for (Shark shark : sharks) {
				if (shark != null) {
					map[shark.r][shark.c] = 0;
					shark.move();
				}
			}
			// 겹치는 상어 죽이기!
			for (int i=0; i<sharks.length; i++) {
				if (sharks[i] == null) continue;
				Shark cur = sharks[i];		//현재 상어

				if (map[cur.r][cur.c] == 0) map[cur.r][cur.c] = i; 		//현재 상어가 가려는 좌표에 다른 상어 없으면
				else {	// 다른 상어 있는 경우 싸움
					int prevShark = map[cur.r][cur.c];	//미리 바다에 있던 상어
					if (cur.size > sharks[prevShark].size) {	// 작은 애 죽고 큰 애가 바다 차지
						sharks[prevShark] = null;
						map[cur.r][cur.c] = i;
					} else sharks[i] = null;	// 기존 상어가 더 쎔
				}
			}
		}
		//output
		bw.write(Integer.toString(size));
		//close
		bw.flush();	bw.close(); br.close();
	}
	static class Shark {
		int r; int c;
		int speed; int dir; int size;

		public Shark(int r, int c, int speed, int dir, int size) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
			// 같은 자리에 돌아오는 speed는 줄여서 저장
			this.speed = this.dir/2==0? speed%(2*(R-1)) : speed%(2*(C-1));
		}

		public void move() {
			for (int i=0; i<this.speed; i++) {
				// 방향 바꾸기
				if (!isValid(this.r + delta[this.dir][0], this.c + delta[this.dir][1])) {
					switch (this.dir) {
						case 0: case 2:
							this.dir++;
							break;
						default:
							this.dir--;
							break;
					}
				}
				// 이동
				this.r += delta[this.dir][0];
				this.c += delta[this.dir][1];
			}
		}
	}
	static boolean isValid(int nr, int nc) {
		return nr>0 && nr<=R && nc>0 && nc<=C;
	}
}
