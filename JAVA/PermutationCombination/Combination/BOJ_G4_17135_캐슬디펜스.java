package JAVA.PermutationCombination.Combination;

/**
 * [BOJ] 17135. 캐슬디펜스 (G4)
 * @category Combination / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-25
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G4_17135_캐슬디펜스 {
	static final int ARC_NUM = 3;			// 궁수 3명
	static int N, M, D;
	static int[] archers;					// 궁수의 j좌표. i는 항상 n+1
	static int maxKill = Integer.MIN_VALUE;	// 최다 킬을 한 궁수 조합
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		List<Enemy> enemies = new ArrayList<>();	//적의 위치를 저장할 원본 리스트
		archers = new int[ARC_NUM];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<M; j++) {
				if (Integer.parseInt(st.nextToken())==1) enemies.add(new Enemy(i, j));			//적들을 리스트에 넣기
			}
		}
		combi(0, 0, enemies);				//M개의 칸 중 궁수가 있을 3칸 MC3조합
		System.out.println(maxKill);
	}
	private static void combi(int cnt, int idx, List<Enemy> enemies) {
		if (cnt == ARC_NUM) {	//조합 완성 조건. 여기 들어오면 궁수 3명의 좌표가 정해짐
			//리스트는 Deep Copy가 안돼서 직접 새로 만들어 줘야 한다.. (원래 적 좌표 담긴 원본 리스트 안변하려고)
			List<Enemy> tmpEnemies = new ArrayList<>();
			for (Enemy enemy: enemies) {
				tmpEnemies.add(new Enemy(enemy.y, enemy.x));
			}
			int killpoint = killEnemies(tmpEnemies);			// 조합으로 정해진 궁수 세명이 적 죽이러 출발
			maxKill = killpoint>maxKill?killpoint:maxKill;		//최대 값 갱신
			return;
		}
		//combination
		if (idx == M) return;
		combi(cnt, idx+1, enemies);
		archers[cnt] = idx;
		combi(cnt+1, idx+1, enemies);
	}
	private static int killEnemies(List<Enemy> enemies) {
		//이번 궁수 세명이 몇명 죽이는지
		int killcnt=0;
		while(!enemies.isEmpty()) {
			boolean[] isTargeted = new boolean[enemies.size()];
			//궁수 셋이 각각 적의 타겟을 선정
			int[] targets = new int[ARC_NUM];
			//타겟이 겹칠수도 있으니 선정된 애만 true로
			for (int i=0; i<ARC_NUM; i++) {
				targets[i] = selectTarget(archers[i], enemies);
				if (targets[i]!=-1) isTargeted[targets[i]] = true;
			}
			//true인 애 제거, 죽은 수만큼 cnt
			//ArrayList에서 원소 제거하면 크기 줄어드니까 뒤에서부터 탐색
			for (int i=isTargeted.length-1; i>=0; i--) {
				if (isTargeted[i]) {
					enemies.remove(i);	//죽이기
					++killcnt;
				}
			}
			//적 이동, 성에 도달하면 제거
			for (int i=enemies.size()-1; i>=0; i--) {
				if (enemies.get(i).y+1==N) enemies.remove(i);
				else enemies.get(i).y += 1;
			}
		}
		return killcnt;
	}
	private static int selectTarget(int j, List<Enemy> enemies) {
		int target = -1;					// 타겟된 적의 인덱스
		int targetx = Integer.MAX_VALUE;	// x 좌표
		int targetDist = Integer.MAX_VALUE;	// 거리
		for (int i=0; i<enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			int dist = Math.abs(N-enemy.y)+Math.abs(j-enemy.x);	//궁수와 적 간의 거리
			if (dist <= D) {				//공격 제한 거리
				if (dist < targetDist) {	//가장 가까운 적 고르기
					target = i;
					targetDist = dist;
					targetx = enemy.x;
				} else if (dist == targetDist) {	//거리 같으면 왼쪽 적으로 고르기
					target = enemy.x<targetx?i:target;
				}
			}
		}
		return target;
	}
	static class Enemy {
		int y; int x;

		public Enemy(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
