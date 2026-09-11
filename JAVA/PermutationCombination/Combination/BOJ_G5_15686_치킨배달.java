package JAVA.PermutationCombination.Combination;

/**
 * [BOJ] 15686. 치킨배달 (G5)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-18
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_G5_15686_치킨배달 {
	static int N, M;
	static int[][] city;
	static int min = Integer.MAX_VALUE;
	static List<Pos> homes, chickens;
	static Pos[] survivedChickens;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		homes = new ArrayList<>();		//주어진 집들의 좌표를 담을 리스트
		chickens = new ArrayList<>();	//주어진 치킨집들의 좌표를 담을 리스트
		//input
		N = Integer.parseInt(st.nextToken());	//맵 크기
		M = Integer.parseInt(st.nextToken());	//남기는 치킨 가게 수
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<N; j++) {
				switch (Integer.parseInt(st.nextToken())) {
					case 1:
						homes.add(new Pos(j, i));		//집들을 쭉 리스트에
						break;
					case 2:
						chickens.add(new Pos(j, i));	//치킨집들을 쭉 리스트에
						break;
				}
			}
		}
		survivedChickens = new Pos[M];				//남길 치킨집 M개
		//입력받은 치킨집들 중 M개만 남기는 조합 실행
		comb(0, 0);
		//output
		System.out.println(min);
	}
	//전체 치킨 집 중에서 M개 고르는 조합
	private static void comb(int cnt, int idx) {
		if (cnt == M) {							//M개의 치킨집 골랐으면
			int chickenDist = getChickDist();	//남겨진 치킨집은 배열에 들어가 있음. 그 조합에서의 치킨 거리를 구함.
			min = chickenDist<min? chickenDist : min;	//최소값 갱신
			return;
		}
		if (idx == chickens.size()) return;		//전체 치킨집을 다 봤으면 만들 수 있는 조합 다 만듬
		comb(cnt, idx+1);						//현재 idx의 치킨집이 폐업된 경우
		Pos chicken = chickens.get(idx);		//현재 idx의 치킨집이 남은 경우
		survivedChickens[cnt] = new Pos(chicken.x, chicken.y);	//현재 치킨집을 생존 리스트에 추가
		comb(cnt+1, idx+1);						//현재 치킨집을 넣은 상태로 다음 치킨집 고르기
	}
	//얘가 실행되었을 땐 M개의 살아남은 치킨집 조합이 완성됨.
	private static int getChickDist() {
		int chickenDist = 0;					//도시의 치킨 거리
		for (int i=0; i<homes.size(); i++) {	//각각의 집에 대해 가장 가까운 치킨집을 남은 치킨집 중 고름
			Pos home = homes.get(i);
			int homeChikenDist = Integer.MAX_VALUE;
			//살아남은 M개의 치킨 집 중 거리가 가장 가까운 것을 현재 집의 치킨 거리로
			for (int m=0; m<M; m++) {
				Pos chicken = survivedChickens[m];
				int curDist = Math.abs(home.x-chicken.x) + Math.abs(home.y-chicken.y);
				homeChikenDist = curDist<homeChikenDist? curDist : homeChikenDist;
			}
			chickenDist += homeChikenDist;
		}
		return chickenDist;
	}
	static class Pos{
		int x; int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
