package JAVA.UnionFind;

/**
 * [SWEA] 7465. 창용마을무리의개수 (D4)
 * @category Union Find
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-09
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_D4_7465_창용마을무리의개수 {
	static int N, M;
	static int[] captains;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());

		for (int tc=1; tc<=TC; tc++) {
			HashSet<Integer> set = new HashSet<>();
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			//대장 초기화 - 일단 내 그룹의 대장은 나
			captains = new int[N];	//인덱스 번호의 사람의 대장 (그룹의 짱)
			for (int i=0; i<N; i++) {
				captains[i] = i;
			}
			//친구 관계끼리 대장 합치기 (그룹화)
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				union(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
			}
			//모든 사람의 대장을 셋에 추가!
			for (int i=0; i<N; i++) {
				set.add(findSet(i));
			}
			//output에 추가
			sb.append(set.size()+"\n");
		}
		//output
		System.out.println(sb.toString());
		//close
		br.close();
	}
	private static void union(int a, int b) {
		//합집합으로 만들기
		int aCap = findSet(a);
		int bCap = findSet(b);
		if (aCap == bCap) return;
		//b대장의 대장 = a대장
		captains[bCap] = aCap;
	}
	private static int findSet(int cur) {
		//내 대장이 나면 리턴
		if (captains[cur]==cur) return cur;
		//내 대장의 대장 찾아서 나의 대장으로
		return captains[cur] = findSet(captains[cur]);
	}
}
