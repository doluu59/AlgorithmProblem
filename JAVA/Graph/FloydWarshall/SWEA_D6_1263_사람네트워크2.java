package JAVA.Graph.FloydWarshall;

/**
 * [SWEA] 1263. 사람네트워크2 (D6)
 * @category Floyd-Warshall
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-16
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_D6_1263_사람네트워크2 {
	static final int INF = 1111;
	static int N, min;
	static int[][] edges;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=TC; tc++) {
			// input
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			edges = new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					edges[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && edges[i][j]==0) { //자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
						edges[i][j]=INF;
					}
				}
			}
			// solve
			// floyd-warshall
			// 경유지-->출발지-->목적지로 3중 루프 돌려야 정답
			for(int k=0; k<N; ++k) {
				for(int i=0; i<N; ++i) {
					if(i==k) continue; // 출발지와 경유지가 같다면 다음 출발지
					for(int j=0; j<N; ++j) {
						if(i==j || k==j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						if(edges[i][j] > edges[i][k]+edges[k][j]) {
							edges[i][j] = edges[i][k]+edges[k][j];
						}
					}
				}
			}
			// 노드 중 최소 값 갱신
			for (int i=0; i<N; i++) {
				int distance = 0;
				for (int j=0; j<N; j++) {
					distance += edges[i][j];
				}
				min = Math.min(min, distance);
			}
			// output
			bw.write("#"+tc+" "+min+"\n");
		}
		// close
		bw.flush(); bw.close(); br.close();
	}
}
