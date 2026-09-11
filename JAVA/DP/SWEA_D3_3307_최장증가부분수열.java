package JAVA.DP;

/**
 * [SWEA] 3307. 최장증가부분수열 (D3)
 * @category DP
 * @implNote
 * - 문제 요약   : LIS
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-14
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_3307_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=TC; tc++) {
			int max = Integer.MIN_VALUE;
			// input
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] nums = new int[N];
			for (int n=0; n<N; n++) {
				nums[n] = Integer.parseInt(st.nextToken());
			}
			// Lis
			int[] LIS = new int[N];
			for (int i=0; i<N; i++) {
				LIS[i] = 1;		// 자기 자신 초기화
				// LIS
				for (int j=0; j<i; j++) {
					if (nums[j] < nums[i] && LIS[i] < LIS[j]+1)
						LIS[i] = LIS[j]+1;
				}
				// 최대값 갱신
				if (max<LIS[i]) max = LIS[i];
			}
			sb.append("#"+tc+" "+max+"\n");
		}
		System.out.println(sb.toString());
	}
}