package JAVA.UnionFind;

/**
 * [BOJ] 17471. 개리멘더링 (G3)
 * @category 조합, dfs, bfs, brute force
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-28
 */

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_G3_17471_게리맨더링 {
	static int N, minDiff=Integer.MAX_VALUE;
	static int[] population;	//index 번호의 노드의 인구수
	static boolean[][] edge;	//엣지 연결 정보
	static int[] parents; 		//그룹 안에 속한 노드 들이 서로 연결된 한 집합인지 보기 위한 내 집합의 대표를 저장
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		// 인구수 input
		population = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		// edge input
		edge = new boolean[N][N];
		for (int n=0; n<N; n++) {		//n과 i가 edge 있다고 표시
			st = new StringTokenizer(br.readLine());
			int conCount = Integer.parseInt(st.nextToken());
			for (int i=0; i<conCount; i++) {
				int to = Integer.parseInt(st.nextToken())-1;
				edge[n][to] = true;
				edge[to][n] = true;
			}
		}

		//n의 부분 집합 => 만들어진 애들의 나머지를 두번째 그룹 두 그룹이 모두 연결 되어 있으면 => 인구 차이 구해서 최소
		subset(0, new ArrayList<Integer>(), new ArrayList<Integer>());
		// output -> 나눌 수 있는 지역구 없으면 -1
		System.out.println(minDiff!=Integer.MAX_VALUE?minDiff:-1);
	}

	private static void subset(int idx, List<Integer> group1, List<Integer> group2) {
		// 노드 N개를 두 그룹으로 다 나눈 경우
		if (idx == N) {
			//여기 오면 그룹 1과 그룹 2에는 각각 나뉜 지역구가 있음.
			if (group1.size()==0 || group2.size()==0) return;		//한쪽 지역구 없으면 안됨
			if (isConnected(group1) && isConnected(group2)) {		//group 둘 다 모두 연결 되어 있어야 함
				int popDiff = Math.abs(popsum(group1)-popsum(group2));	//인구수 차이
				minDiff = popDiff < minDiff ? popDiff : minDiff;		//최소 인구수 차이 갱신
			}
			return;
		}
		// 이번 노드가 그룹 1일 때
		subset(idx+1, copyList(group1, idx), group2);
		// 이번 노드가 그룹 2일 때
		subset(idx+1, group1, copyList(group2, idx));
	}
	// Collection 깊은 복사 안돼서 새로운 리스트 만들어서 복사해줘야 함. + 이번 노드도 넣어주기
	private static List<Integer> copyList(List<Integer> group, int idx) {
		List<Integer> temp = new ArrayList<>();
		for (int i: group) {
			temp.add(i);
		}
		temp.add(idx);
		return temp;
	}
	// 지역구의 인구 합계
	private static int popsum(List<Integer> group) {
		int sum = 0;
		for (int idx : group) {
			sum += population[idx];
		}
		return sum;
	}
	// group에 속한 노드들이 모두 직간접적 연결된 그룹인지
	private static boolean isConnected(List<Integer> group) {
		if (group.size()==1) return true;

		// 집합을 분류하기 위해 초기 서로 단위 집합 생성
		parents = new int[N];
		for (int i=0; i<N; i++) {
			parents[i] = i;
		}
		// 연결된 엣지가 있으면 둘이 같은 집합으로
		for (int i=0; i<group.size(); i++) {
			for (int j=i+1; j<group.size(); j++) {
				if (edge[group.get(i)][group.get(j)]) {		//연결되어있다면
					//둘은 연결되었으니 같은 집합으로 분류
					union(group.get(i), group.get(j));
				}
			}
		}

		// 모두 같은 그룹이면 set의 크기 1이어야 함.
		HashSet<Integer> set = new HashSet<>();
		for (int nodeIdx: group) {
			set.add(findSet(nodeIdx));
		}
		if (set.size()==1) return true;
		else return false;
	}
	// union
	private static void union(Integer a, Integer b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot==bRoot) return;
		parents[bRoot] = aRoot;
		return;
	}
	// 집합 대표 찾기
	private static int findSet(Integer cur) {
		if (cur==parents[cur]) return cur;
		return parents[cur] = findSet(parents[cur]);
	}
}

