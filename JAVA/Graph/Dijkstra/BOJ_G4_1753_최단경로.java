package JAVA.Graph.Dijkstra;

/**
 * [BOJ] 1753. 최단경로 (G4)
 * @category Dijkstra
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-30
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_1753_최단경로 {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine())-1;
		//엣지 추가
		List<Node>[] edge = new ArrayList[V];	//인접 리스트
		for (int i=0; i<V; i++) {
			edge[i] = new ArrayList<>();
		}
		for (int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			edge[from].add(new Node(to, w));
		}

		//dijkstra
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] distance = new int[V];		// 해당 노드로 오는 최소 거리
		Arrays.fill(distance, INF);			// 초기화
		boolean[] visited = new boolean[V];	// 방문 여부
		// 시작 노드로 향하게 PQ 초기화
		pq.add(new Node(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();			// PQ에서 distance 최소인 노드 꺼내 옴.
			if (visited[cur.idx]) continue;	// 방문한 노드면 skip
			visited[cur.idx] = true;		// 방문처리

			for (Node adj : edge[cur.idx]) {	//현재 노드의 인접 노드 중
				if (distance[adj.idx] > distance[cur.idx] + adj.weight) {	//가중치만 다른 같은 노드도 알아서 거리가 갱신 됨
					distance[adj.idx] = distance[cur.idx] + adj.weight;		//거리 갱신
					pq.add(new Node(adj.idx, distance[adj.idx]));			// 갱신한 노드를 PQ에
				}
			}
		}
		//output
		for (int i=0; i<V; i++) {
			if (distance[i] != INF) sb.append(distance[i]);
			else sb.append("INF");
			sb.append("\n");
		}
		bw.write(sb.toString());
		//close
		bw.flush(); bw.close(); br.close();
	}
	static class Node implements Comparable<Node> {
		int idx; int weight;
		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;	//PQ의 비교 기준
		}
	}
}
