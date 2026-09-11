package JAVA.Search.DFSnBFS.BFS;

/**
 * [BOJ] 1697. 숨바꼭질 (S1)
 * @category BFS
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-22
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_1697_숨바꼭질 {
	static int start, end;
	static boolean[] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());	//수빈이 위치
		end = Integer.parseInt(st.nextToken());		//동생 위치

		isVisited = new boolean[200001];
		// output
		System.out.println(bfs(start).time);	//bfs에서 수빈이 객체가 반환 => toString 오버라이딩해서 출력 포매팅
		// close
		br.close();
	}
	//bfs의 return 객체가 Subin class
	private static Subin bfs(int start) throws IOException {
		Queue<Subin> queue = new ArrayDeque<>();

		//시작점
		queue.offer(new Subin(start, 0));
		isVisited[start] = true;

		//도착할 떄까지 반복
		while(!queue.isEmpty()) {
			//이번에 큐에서 꺼낸 현재 수빈이 정보
			Subin cur = queue.poll();
			if(cur.pos == end) return cur;	//동생 찾았으면 bfs 종료

			int curMinus = cur.pos-1;
			int curPlus = cur.pos+1;
			int curMulti = cur.pos*2;
			//현재 위치가 도착지보다 큰 숫자 좌표이면 +와 *는 생략
			if (cur.pos<end) {
				if (isValid(curMulti)) {
					queue.offer(new Subin(curMulti, cur.time+1));
					isVisited[curMulti] = true;
				}
				if (isValid(curPlus)) {
					queue.offer(new Subin(curPlus, cur.time+1));
					isVisited[curPlus] = true;
				}
			}
			if (isValid(curMinus)) {
				queue.offer(new Subin(curMinus, cur.time+1));
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
		public Subin(int pos, int time) {
			this.pos = pos;
			this.time = time;
		}
	}
}
