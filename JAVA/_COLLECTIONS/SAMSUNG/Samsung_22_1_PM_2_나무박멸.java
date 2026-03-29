package JAVA._COLLECTIONS.SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * @author 삼성 2022 상반기 오후 2번
 * @from Code Tree
 * @title 나무박멸
 * @grade G4
 * @category 구현, 시뮬레이션
 */
public class Samsung_22_1_PM_2_나무박멸 {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int[] ky = { -1, -1, 1, 1 };
	static int[] kx = { -1, 1, -1, 1 };
	static int N, M, K, C;
	static int[][] map;
	static int[][] spray;	// 제초제가 남은 유효 시간. -1일 경우는 제초제 없이 현재 나무가 있다는 뜻
	static int kill=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// input
		N = Integer.parseInt(st.nextToken());	// 격자 크기
		M = Integer.parseInt(st.nextToken());	// 진행 년수
		K = Integer.parseInt(st.nextToken());	// 제초제 확산 범위
		C = Integer.parseInt(st.nextToken());	// 제초제 남은 년수
		map = new int[N][N];
		spray = new int[N][N];
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] > 0) spray[r][c] = -1;	// 나무가 있는 위치는 -1
				
			}
		}
		// 
		for (int time=0; time<M; time++) {
			// 1. 나무 성장
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (spray[r][c] != -1) continue;	// 나무 없으면 넘어가기
					int cnt=0;
					for (int d=0; d<4; d++) {		// 인접 4방 탐색
						int nr = r + dy[d];
						int nc = c + dx[d];
						if(!isValidPos(nr, nc)) continue;
						if (spray[nr][nc] == -1) cnt++;	// 나무 있는 칸만큼 증가
						
					}
					map[r][c] += cnt;
				}
			}
//			System.out.println("==========1단계===========");
//			for (int r=0; r<N; r++) {
//				System.out.println(Arrays.toString(map[r]));
//			}
			// 2. 인접 4개 칸에 나무 번식
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (spray[r][c] != -1) continue;	// 나무 없으면 넘어가기
					List<Integer> newTreeIdx = new ArrayList<>();	//새로 번식될 나무의 위치
					int breedNum = 0;				// 번식 되는 나무의 수
					for (int d=0; d<4; d++) {		// 인접 4방 탐색
						int nr = r + dy[d];
						int nc = c + dx[d];
						if(!isValidPos(nr, nc)) continue;
						if (spray[nr][nc] != 0) continue;		// 제초제, 다른 나무 무시
						if (map[nr][nc] >= 0) {				//벽이 아니면
							breedNum++;
							newTreeIdx.add(d);
						}
					}
					// 번식할 곳이 있으면 키워주기
					if (breedNum != 0) {
						int newN = map[r][c] / breedNum;
						for (int d : newTreeIdx) {
							map[r+dy[d]][c+dx[d]] += newN;
						}
					}
				}
			}
			// 번식 끝난 후 트리에 추가
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (map[r][c] > 0) spray[r][c] = -1;
				}
			}
//			System.out.println("==========2단계===========");
//			for (int r=0; r<N; r++) {
//				System.out.println(Arrays.toString(map[r]));
//			}
			
			// 4. 제초제 유효기간 줄이기
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
	                if(spray[r][c] > 0) spray[r][c] -= 1;
				}
			}
			
			// 3. 제초제 뿌리기
			// 3.1 제초제 뿌릴 위치 찾기
			int max = 0;
			int maxR = 0, maxC = 0;
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (spray[r][c] != -1) continue;	//나무 있는 구역만 후보
					int treeCnt = map[r][c];
					for (int d=0; d<4; d++) {
						for (int k=1; k<=K; k++) {
							int nr = r + k*ky[d];
							int nc = c + k*kx[d];
							if (!isValidPos(nr, nc)) break;
							if (map[nr][nc] <= 0) break; 		// 나무가 아니면
							treeCnt += map[nr][nc];
						}
					}
					if (treeCnt > max) {
						max = treeCnt;
						maxR = r;
						maxC = c;
					}
				}
			}
			// 나무 박멸 수 갱신
			kill += max;
			
			// 3.2 정한 곳에 제초제 뿌리기
			if (map[maxR][maxC] > 0) {
				map[maxR][maxC] = 0;
				spray[maxR][maxC] = C;
				for (int d=0; d<4; d++) {
					for (int k=1; k<=K; k++) {
						int nr = maxR + k*ky[d];
						int nc = maxC + k*kx[d];
						if (!isValidPos(nr, nc)) break;		// oob
						if (map[nr][nc] < 0) break; 		// 벽
						if (map[nr][nc] == 0) {				// 맨 땅은 해당 위치까지만 제초제 뿌리고 그 뒤는 멈추기
							spray[nr][nc] = C;
							break;
						}
						map[nr][nc] = 0;
						spray[nr][nc] = C;
					}
				}
			}
		}
		System.out.println(kill);
	}
	private static boolean isValidPos(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
