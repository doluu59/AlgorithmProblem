package JAVA.Search.DFSnBFS.BFS;

/**
 * [BOJ] 9205. 맥주걸어가면서마시기 (G5)
 * @category Graph Search - BFS
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-12
 */
 
public class BOJ_G5_9205_맥주마시면서걸어가기 {
	static int storeN;			// 편의점 수
	static Pos[] store;			// 편의점
	static boolean[] visited;	// 편의점 방문 체크
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=TC; tc++) {
			// input
			storeN = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Pos start = new Pos(Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken()));		// 출발지 (집)
			store = new Pos[storeN];
			for (int n=0; n<storeN; n++) {
				st = new StringTokenizer(br.readLine());
				store[n] = new Pos(Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken()));	// 편의점
			}
			visited = new boolean[storeN];
			st = new StringTokenizer(br.readLine());
			Pos end = new Pos(Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken()));			// 도착지 (페스티벌)
			// solve, output
			String output = solve(start, end)? "happy\n" : "sad\n";		// 도착지에 갈 수 있으면 true, 없으면 false
			bw.write(output);
		}
		// close
		bw.flush(); bw.close(); br.close();
	}
	private static boolean solve(Pos start, Pos end) {
		// bfs로 출발지부터 시작하여 방문할 수 있는 편의점에 들림.
		// 편의점에서 나오면 현 위치에서 도착지까지의 거리가 1000(맥주 20병) 이하인지 체크
		// => 도착지까지 갈 수 있으면 방문 가능
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(start);

		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			// 현 위치에서 도착지까지 갈 수 있는지 확인
			if (getDistance(cur, end) <= 1000) return true;
			// 현 위치에서 들릴 수 있는 편의점 체크
			for (int i=0; i<storeN; i++) {
				if (!visited[i] && getDistance(cur, store[i]) <= 1000) {
					visited[i] = true;
					queue.offer(store[i]);
				}
			}
		}
		return false;
	}
	private static int getDistance(Pos cur, Pos dst) {
		return Math.abs(cur.x-dst.x)+Math.abs(cur.y-dst.y);
	}
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
