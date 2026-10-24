package JAVA.UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [SWEA] 3289. 서로소집합 (D4)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-08
 */
 
public class SWEA_D4_3289_서로소집합 {
	static int N, M;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();	//정답 다 모아서 한번에 출력할 것
		int TC = Integer.parseInt(br.readLine());	//TC 수
		for (int tc = 1; tc<=TC; tc++) {
			//output format
			sb.append("#"+tc+" ");
			// input - TC별
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			//대장 초기화
			parents = new int[N];
			for (int i=0; i<N; i++) {
				parents[i] = i;
			}
			// M번의 연산 수행
			for (int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				switch (st.nextToken()) {
					case "0":
						union(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
						//유니온
						break;
					case "1":
						// 대장 똑같으면 1, 아니면 0
						sb.append(findSet(Integer.parseInt(st.nextToken())-1)==findSet(Integer.parseInt(st.nextToken())-1)?1:0);//부모 같은지 확인
						break;
				}
			}
			sb.append("\n");	//TC 하나 끝날 때마다 줄 바꿔주기
		}
		//output
		bw.write(sb.toString());	//결과값 다 모아서 한번에 출력
		//close
		bw.flush(); bw.close(); br.close();
	}
	private static void union(int a, int b) {
		int aCaptain = findSet(a);
		int bCaptain = findSet(b);
		if (aCaptain==bCaptain) return;

		parents[bCaptain] = aCaptain;
	}
	private static int findSet(int cur) {
		if (parents[cur]==cur) return cur;
		return parents[cur] = findSet(parents[cur]);	//내 대장의 대장을 찾아서 걜 내 대장으로 지정
	}
}
