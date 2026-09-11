package JAVA.Greedy;

/**
 * [BOJ] 16435. 스네이크버드 (S5)
 * @category Greedy, Sorting
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-19
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S5_16435_스네이크버드 {
	public static void main(String[] args) throws IOException {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] fruits = new int[N];
		for (int i=0; i<N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(fruits);			//입력받은 과일의 높이 정렬
		for (int i=0; i<N; i++) {
			if (fruits[i] <= L) L++;	//새 높이보다 갖거나 낮은 과일은 먹어서 크기가 커짐
			else break;					//과일이 새보다 높으면 더 이상 못먹어요
		}
		System.out.println(L);
	}
}
