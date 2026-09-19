package JAVA.Simulation;

/**
 * [BOJ] 17281. 야구 (G4)
 * @category 구현 / Simulation / 순열
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-03
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G4_17281_야구 {
	static final int PLAYER_NUM = 9;
	static int Inning, MaxScore=Integer.MIN_VALUE;	// 총 이닝, 타순 중 최고 득점
	static int[][] records;							// 등번호별 이닝 당 기록
	static int[] battingOrder;						// 타순
	static int isOrdered=0;							// 타순에 등록된 선수인지 플래그
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Inning = Integer.parseInt(br.readLine());
		records = new int[Inning][PLAYER_NUM];
		battingOrder = new int[PLAYER_NUM];
		for (int i=0; i<Inning; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<PLAYER_NUM; j++) {
				records[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 순열
		battingOrder[3] = 0;	//0번째 선수는 4번 고정
		isOrdered |= 1<<0;
		perm(0);
		// 최대 득점 출력
		System.out.println(MaxScore);
	}
	private static void perm(int cnt) {
		if (cnt == PLAYER_NUM) {
			int score = playBall();		// 타순 정해지면 그 타순으로 경기
			if (score > MaxScore) MaxScore = score;
			return;
		}
		if (cnt==3) {	// 4번 타자는 고정. 다음 타순 짜러 가기
			perm(cnt+1);
			return;
		}
		// 순열 구현
		for (int i=1; i<PLAYER_NUM; i++) {			// 4번타자인 0번 선수는 지정 해놨으니 고려 대상 X
			if ((isOrdered & 1<<i) != 0) continue;	//이미 배정된 타순 있는 선수는 제외
			battingOrder[cnt] = i;					//타순에 i 선수 배정
			isOrdered |= 1<<i;						//타순에 배치된 선수는 오더 등록 마킹
			perm(cnt+1);							//다음 타순 짜러 가기
			isOrdered &= ~(1<<i);					//타순 끝났으면 배정했던 선수 돌리기
		}
	}
	private static int playBall() {
		int score = 0;
		int curPlayer = 0;		//점수랑 타순은 이닝끼리 연관 있음

		for (int inning=0; inning<Inning; inning++) {
			ArrayList<Integer> runners = new ArrayList<>();	// 주자는 어레이 리스트로 관리. 이닝마다 주자 초기화
			int outCnt=0;	//아웃 카운트 초기화
			while (outCnt < 3) {
				// 현재 타자 기록
				int curBatterResult = records[inning][battingOrder[curPlayer]];
				if (curBatterResult==0) ++outCnt;	//아웃
				else {		// 칠 때마다 베이스 러닝
					for (int i=runners.size()-1; i>=0; i--) {
						runners.set(i, runners.get(i)+curBatterResult);		// 주자들 진루
						if (runners.get(i)>3) {
							// 주자 중에 홈 찍은 사람 있으면 루상에서 지우고 득점
							score++;
							runners.remove(i);
						}
					}
					// 타자 진루
					if (curBatterResult == 4) score++;	//RUN
					else runners.add(curBatterResult);	//타자 진루
				}
				// Coming UP Hitter
				curPlayer = (curPlayer+1)%PLAYER_NUM;
			}	// 한 이닝
		}	// 한 경기
		return score;	// 이 경기 득점 리턴
	}
}
