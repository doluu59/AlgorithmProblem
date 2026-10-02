package JAVA.Graph.MST;

/**
 * [SWEA] 3124. 최소스패닝트리 (D4)
 * @category 최소 신장 트리(MST), Prim, Kruskal, Priority Queue
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-11
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_D4_3124_최소스패닝트리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			// Prim

			// 내 노드로 오는 가장 짧은 간선
			List<Vertex>[] edgeList = new ArrayList[V];	//인덱스 노드에서 출발하는 edge를 리스트로 관리 (adjList)
			boolean[] isSelected = new boolean[V];		//해당 노드가 Spanning Tree에 선택 되었는지
			int[] minEdge = new int[V];					//해당 노드로 오는 가장 짧은 edge의 weight
			// 초기화
			for (int i=0; i<V; i++) {
				minEdge[i] = Integer.MAX_VALUE;
				edgeList[i] = new ArrayList<>();
			}
			// edge input
			for (int e=0; e<E; e++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				int weight = Integer.parseInt(st.nextToken());
				edgeList[from].add(new Vertex(to, weight));
				edgeList[to].add(new Vertex(from, weight));
			}

			long result=0;		// MST의 weight 합
			int nodeCount=0;	// spanning tree에 선택된 노드 수
			minEdge[0] = 0;		//시작 노드로 오는 간선은 0
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(0, 0));	//0으로 가는 0짜리 엣지가 시작 엣지

			while(!pq.isEmpty()) {
				Vertex curVertex = pq.poll();					//이번에 선택된 엣지 => 얘가 도착하는 노드에 인접한 엣지들을 또 봐야 함
				if(isSelected[curVertex.idx]) continue;		//이미 방문한 노드로 가는 간선이면 버리기
				// 방문 안한 노드로 가는 간선을 꺼냄
				isSelected[curVertex.idx] = true;

				//선택했으면 MST에 값 반영
				result += curVertex.weight;
				if(++nodeCount==V) break;

				// 도착지에서 인접한 간선들을 가져오기
				for (Vertex adj : edgeList[curVertex.idx]) {
					// spanning tree에 포함 안된 노드로 가는 엣지인지 && 엣지의 가중치가 현재 도착지에 가는 가장 짧은 엣지인지
					if (!isSelected[adj.idx] && minEdge[adj.idx] > adj.weight) {
						minEdge[adj.idx] = adj.weight;				//노드로 오는 최단 엣지 갱신
						pq.offer(adj);		//PQ에 추가 => 스패닝 트리에 선택된 엣지
					}
				}
			}
			//output
			sb.append("#"+tc+" "+result+"\n");
		}
		//tc 모아서 한번에 출력
		System.out.println(sb.toString());
	}
	static class Vertex implements Comparable<Vertex>{
		int idx;
		int weight;
		public Vertex(int to, int weight) {
			this.idx = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.weight-o.weight;
		}
	}
}
