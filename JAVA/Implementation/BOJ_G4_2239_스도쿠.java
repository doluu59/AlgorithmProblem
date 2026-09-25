package JAVA.Implementation;

/**
 * [BOJ] 2239. 스도쿠 (G4)
 * @category Implementation / BackTracking
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-09
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ_G4_2239_스도쿠 {
	static final int N = 9;
	static int[][] map;
	static List<Pos> blanks = new ArrayList<>();
	static StringBuilder sb = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// input
		map = new int[N][N];
		for (int r=0; r<N; r++) {
			String str = br.readLine();
			for (int c=0; c<N; c++) {
				map[r][c] = str.charAt(c)-'0';
				if (map[r][c]==0) blanks.add(new Pos(r, c));	// 0인 칸은 채워야 하는 칸이므로 모두 리스트에 넣기
			}
		}
		//
		fill(0);	//
		// output
		bw.write(sb.toString());
		// close
		bw.flush(); bw.close(); br.close();
	}
	// cnt개 만큼 빈 칸을 채움. 빈 칸의 총 갯수만큼 숫자를 다 채운 후 스도쿠 조건이 맞는지 전체 확인
	private static void fill(int cnt) {
		if (sb != null) return;		// 이미 스도쿠 완성된 게 있으면 다 생략
		if (cnt==blanks.size()) { 	// 빈 칸에 수를 다 채운 경우  스도쿠 조건을 만족하는 지
			//가로 줄 체크
			for (int r=0; r<N; r++) {
				int rflag = 0;
				for (int c=0; c<N; c++) {
					rflag |= 1<<map[r][c];
				}
				for (int i=1; i<=N; i++) {
					if ((rflag & 1<<i) == 0) return;	//빈 수가 있으면 실패
				}
			}
			//세로 줄 체크
			for (int c=0; c<N; c++) {
				int cflag = 0;
				for (int r=0; r<N; r++) {
					cflag |= 1<<map[r][c];
				}
				for (int i=1; i<=N; i++) {
					if ((cflag & 1<<i) == 0) return;	//빈 수가 있으면 실패
				}
			}
			//네모 줄 체크
			for (int i=0; i<N; i++) {
				int squareflag = 0;
				for (int r=3*(i/3); r<3*(i/3)+3; r++) {
					for (int c=3*(i%3); c<3*(i%3)+3; c++) {
						squareflag |= 1<<map[r][c];
					}
				}
				for (int k=1; k<=N; k++) {
					if ((squareflag & 1<<k) == 0) return;	//빈 수가 있으면 실패
				}
			}
			// 여기까지 살아남으면 스도쿠 조건 만족
			sb = new StringBuilder();
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			return;
		}
		// 현재 빈칸의 좌표의 가로 세로 네모 범위를 확인하여 사용 가능한 숫자 찾기
		int canUse = 0;
		Pos cur = blanks.get(cnt);
		// 세로로 불가능한 수 추가
		for (int r=0; r<N; r++) {
			if (map[r][cur.c] != 0) {
				canUse |= 1<<map[r][cur.c];
			}
		}
		// 가로로
		for (int c=0; c<N; c++) {
			if (map[cur.r][c] != 0) {
				canUse |= 1<<map[cur.r][c];
			}
		}
		// 네모 범위로
		for (int r=3*(cur.r/3); r<3*(cur.r/3)+3; r++) {
			for (int c=3*(cur.c/3); c<3*(cur.c/3)+3; c++) {
				if (map[r][c] != 0) {
					canUse |= 1<<map[r][c];
				}
			}
		}
		// 현재 위치 좌표에 사용 가능한 수를 리스트에 추가
		List<Integer> canUseList = new ArrayList<>();
		for (int i=1; i<=9; i++) {
			if ((canUse&1<<i) == 0) canUseList.add(i);	// 1~9 중 사용되지 않은 수는 사용 가능한 수
		}
		if (canUseList.size()==0) return;	// 쓸 수 있는 숫자가 없다면 잘못된 것이므로 백트래킹
		// 가능한 수만 반복!
		for (int canUseNum : canUseList) {
			map[cur.r][cur.c] = canUseNum;	// 가능한 숫자를 넣어보기
			fill(cnt+1);					// 넣은 상태로 다음 빈칸 채우러 가기
			map[cur.r][cur.c] = 0;			// 돌아왔으면 값 되돌리기
		}
	}
	static private class Pos {
		int r,c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
