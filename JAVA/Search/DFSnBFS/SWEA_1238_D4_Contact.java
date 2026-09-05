package JAVA.Search.DFSnBFS;

/**
 * [SWEA] D4. Contact (1238)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-10
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_D4_Contact {
	static final int N = 101;
	static boolean[][] edge;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TC = 10;
		for (int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int D = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			edge = new boolean[N][N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int d=0; d<D/2; d++) {
				edge[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}

			// BFS
			System.out.println("#"+tc+" "+bfs(start));
		}

	}

	private static int bfs(int start) {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		int depth = 0;
		int maxDepth = Integer.MIN_VALUE;
		int maxNum = Integer.MIN_VALUE;
		queue.offer(new Node(start, depth));
		visited[start] = true;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			//방문해서 하는 일!
			if (cur.depth > maxDepth) {		//더 깊은 깊이로 왔으면 갱신
				maxDepth = cur.depth;
				maxNum = cur.no;
			} else if (cur.depth == maxDepth) {		// 같은 깊이면 큰 번호로 저장
				maxNum = cur.no > maxNum ? cur.no : maxNum;
			}

			//인접 점들 큐에 넣고 방문 처리 하기!
			for (int i=0; i<N; i++) {
				if (edge[cur.no][i] && !visited[i]) {
					queue.offer(new Node(i, cur.depth+1));
					visited[i]= true;
				}
			}
		}

		return maxNum;
	}

	static class Node {
		int no; int depth;

		public Node(int no, int depth) {
			this.no = no;
			this.depth = depth;
		}
	}
}
