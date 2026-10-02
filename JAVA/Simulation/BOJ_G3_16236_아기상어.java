package JAVA.Simulation;

/**
 * [BOJ] 16236. 아기상어 (G3)
 * @category 구현, 시뮬레이션, 그래프 탐색, BFS
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-02
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_16236_아기상어 {
	static class Fish {
		int i, j, size;
		public Fish(int i, int j, int size) {
			this.i = i;
			this.j = j;
			this.size = size;
		}
	}
	static class Shark extends Fish {
		int eaten;
		public Shark(int i, int j, int size) {
			super(i, j, size);
			this.eaten = 0;
		}
		public void canSizeUp() {
			// 먹은 양이 지금 크기보다 크면 크기 1늘리고, 먹은 양은 원래 크기만큼 줄여주기
			while (this.eaten >= this.size) {
				this.eaten -= this.size++;
			}
		}
	}
	static int N, time;
	static int[][] map;
	static Shark babyShark;
	static List<Fish> fishlist;
	static int[] di = { -1, 1, 0, 0};
	static int[] dj = { 0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		fishlist = new ArrayList<>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					babyShark = new Shark(i, j, 2);
					map[i][j] = 0;
				} else if (map[i][j]>0) {
					fishlist.add(new Fish(i, j, map[i][j]));
				}
			}
		}

		while(fishlist.size()>0) {
			int target = -1;
			int targetDist = -1;
			int[] flag;
			int curDist;
			// 먹을 물고기 찾기
			for (int i=0; i<fishlist.size(); i++) {
				// 물고기가 상어보다 작으면
				if (babyShark.size > fishlist.get(i).size) {
					// 그 물고기랑 거리 구하기
					flag = new int[N];
					curDist = getDistance(fishlist.get(i), flag);
					if (curDist==-1) continue;	//못가면 버리기
					// 1마리면 거기로 이동
					if (target == -1) {
						target = i;
						targetDist = curDist;
					}
					// 1마리 이상이면 가장 가까운 물고기
					else {
						if (curDist < targetDist) {
							target = i;
							targetDist = curDist;
						} else if (curDist == targetDist) {
							// 거리 같으면 위, 왼쪽이 우선 순위
							if (fishlist.get(i).i < fishlist.get(target).i ) {
								target = i;
							} else if (fishlist.get(i).i == fishlist.get(target).i) {
								target = (fishlist.get(i).j < fishlist.get(target).j) ? i : target;
							}
						}
					}
				}
			}
			// 타겟 선정
			// 먹을 수 있는 물고기 없으면 종료
			if (target == -1) {
				break;
			} else {
				// 상어 이동
				time += targetDist;
				map[babyShark.i][babyShark.j] = 0;	//원래 상어 위치는 빈자리로
				babyShark.i = fishlist.get(target).i;
				babyShark.j = fishlist.get(target).j;
				// 그 물고기 죽이기
				babyShark.eaten++;
				fishlist.remove(target);
				//커질 수 있으면 커지기
				babyShark.canSizeUp();
			}
		}
		// 큐에 아기 상어 좌표 넣어서 움직
		System.out.println(time);
	}

	// 상어랑 물고기 간 거리 구하기
	private static int getDistance(Fish fish, int[] flag) {
		int distance = -1;
		Queue<int[]> queue = new ArrayDeque<>();

		//초기 상어 위치
		queue.offer(new int[] { babyShark.i, babyShark.j, 0 });
		flag[babyShark.i] |= 1<<babyShark.j;	//방문 처리

		// bfs로 한칸씩 이동하면서 물고기 만나면 종료
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();	//0은 i, 1은 j, 2는 depth (= 거리)
			// 물고기 발견!
			if (cur[0]==fish.i && cur[1]==fish.j) {
				distance = cur[2];
				break;
			}
			int ni, nj;
			// 발견 못하면 다음 길로 이동
			for (int d=0; d<4; d++) {
				ni = cur[0] + di[d]; nj = cur[1] + dj[d];
				// 나보다 더 큰 물고기는 못 지나감. 같은 애는 가능
				if (isValid(ni, nj) && map[ni][nj] <= babyShark.size && (flag[ni] & 1<<nj) == 0 ) {
					flag[ni] |= 1<<nj;	//방문 처리
					queue.offer(new int[] {ni, nj, cur[2]+1});
				}
			}
		}
		return distance;
	}
	private static boolean isValid(int i, int j) {
		return i>=0 && i<N && j>=0 && j<N;
	}
}
