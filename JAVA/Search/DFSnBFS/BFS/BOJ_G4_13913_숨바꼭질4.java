package JAVA.Search.DFSnBFS.BFS;

/**
 * [BOJ] 13913. 숨바꼭질4 (G4)
 * @category BFS
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-24
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_13913_숨바꼭질4 {
	static int start, end;
	static boolean[] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		start = Integer.parseInt(st.nextToken());	//수빈이 위치
		end = Integer.parseInt(st.nextToken());		//동생 위치

		isVisited = new boolean[200001];
		// output
		bw.write(bfs(start).toString());	//bfs에서 수빈이 객체가 반환 => toString 오버라이딩해서 출력 포매팅
		// close
		bw.flush(); bw.close();
		br.close();
	}
	//bfs의 return 객체가 Subin class
	private static Subin bfs(int start) throws IOException {
		Queue<Subin> queue = new ArrayDeque<>();

		//시작점
		queue.offer(new Subin(start, 0, new int[] {}));
		isVisited[start] = true;

		//도착할 떄까지 반복
		while(!queue.isEmpty()) {
			//이번에 큐에서 꺼낸 현재 수빈이 정보
			Subin cur = queue.poll();
			if(cur.pos == end) return cur;	//동생 찾았으면 bfs 종료

			// 현재 위치 경로에 추가
			int[] temp = null;
			temp = Arrays.copyOf(cur.path, cur.path.length+1);
			temp[temp.length-1] = cur.pos;

			int curMinus = cur.pos-1;
			int curPlus = cur.pos+1;
			int curMulti = cur.pos*2;
			//현재 위치가 도착지보다 큰 숫자 좌표이면 +와 *는 생략
			if (cur.pos<end) {
				if (isValid(curMulti)) {
					queue.offer(new Subin(curMulti, cur.time+1, temp));
					isVisited[curMulti] = true;
				}
				if (isValid(curPlus)) {
					queue.offer(new Subin(curPlus, cur.time+1, temp));
					isVisited[curPlus] = true;
				}
			}
			if (isValid(curMinus)) {
				queue.offer(new Subin(curMinus, cur.time+1, temp));
				isVisited[curMinus] = true;
			}
		}
		return null;
	}
	private static boolean isValid(int pos) {
		return pos>=0 && pos<=100000 && !isVisited[pos];
	}
	//BFS 돌아가면서 현재 수빈이 위치, 이동 시간, 현재까지의 경로를 담을 객체
	static class Subin {
		int pos;
		int time;
		int[] path;
		public Subin(int pos, int time, int[] path) {
			this.pos = pos;
			this.time = time;
			this.path = path;
		}
		@Override
		public String toString() {
			// output format
			StringBuilder sb = new StringBuilder();
			// 시간
			sb.append(this.time+"\n");
			// 경로
			for (int path : this.path) {
				sb.append(path+" ");
			}
			sb.append(this.pos+"\n");
			return sb.toString();
		}
	}
}
