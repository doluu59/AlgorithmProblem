package JAVA.DivideAndConquer;

/**
 * [BOJ] 1074. Z (S1)
 * @category Devide and Conquer, Recursion
 * @implNote
 * - 문제 요약   :
 *  이차원 배열에 탐색 순서대로 마킹하는 것은 메모리 초과 남.
 *  4등분 중 목적지가 속한 부분만 실행하면서 인덱스 처리
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-20
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_1074_Z {
	static int idx=0, R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		//2*n가 한 변의 길이, 시작점은 0, 0
		searchZ((int) Math.pow(2, N), 0, 0);
		System.out.println(idx);

	}
	//4등분 한 구역 중에 어디로 가야될지 찾아서 점점 범위를 줄여 나감
	private static void searchZ(int n, int r, int c) {
		if(n==1) {
			if (r==R &&c==C) return;
			else idx++;
			return ;
		}
		int half = n/2;
		if (R<r+half) {
			if (C<c+half) {
				searchZ(n/2, r, c);			//좌상
			} else {
				idx += half*half;
				searchZ(n/2, r, c+n/2);		//우상
			}
		} else {
			if (C<c+half) {
				idx += half*half*2;
				searchZ(n/2, r+n/2, c);		//좌하
			} else {
				idx += half*half*3;
				searchZ(n/2, r+n/2, c+n/2);	//우하
			}
		}
//		//메모리초과남
//		if(n==2) {
//			map[startr][startc] = idx++;
//			map[startr][startc+1] = idx++;
//			map[startr+1][startc] = idx++;
//			map[startr+1][startc+1] = idx++;
//			return;
//		}
//		searchZ(n/2, startr, startc);
//		searchZ(n/2, startr, startc+n/2);
//		searchZ(n/2, startr+n/2, startc);
//		searchZ(n/2, startr+n/2, startc+n/2);
	}
}
