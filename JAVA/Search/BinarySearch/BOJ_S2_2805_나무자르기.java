package JAVA.Search.BinarySearch;

/**
 * [BOJ] 2805. 나무자르기 (S2)
 * @category Binary Search
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   :
 *  처음에는 나무 길이를 정렬한 후 제일 긴 순서대로 맞추려했지만
 *  N이 100만 이하의 수이기 때문에 O(N)짜리 탐색은 너무 오래 걸림.
 *  => 이분 탐색을 하면 O(logN)이라 최대 20회 정도면 탐색이 끝남
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-21
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_2805_나무자르기 {
	static int[] woods;
	static int N, H= Integer.MIN_VALUE;
	static long M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());

		woods = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			woods[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(woods);
		//자르는 높이를 0~가장 긴 나무 길이까지 해서 이분 탐색으로 검색
		biSearch(0, woods[N-1]);
		System.out.println(H);
	}
	private static void biSearch(int start, int end) {
		if (start <= end) {
			int mid = (start + end) / 2;
			long m = cutting(mid);
			if (m < M) {		//목표치보다 덜 잘랐다면 높이 줄여서 더 잘라야 함
				biSearch(start, mid-1);
			} else if (m > M){	//목표치보다 더 잘랐으면 일단 저장은 해두고, 최대한 더 자를 수 있어야 함.
				H = mid;
				biSearch(mid+1, end);
			} else {			//목표치랑 완전 일치하면 그만!
				H = mid;
				return;
			}
		}
		return;
	}
	private static long cutting(int h) {	//자른 길이 구하기
		long sum =0;
		for (int wood: woods) {
			sum += wood>h?wood-h:0;
		}
		return sum;
	}
}
