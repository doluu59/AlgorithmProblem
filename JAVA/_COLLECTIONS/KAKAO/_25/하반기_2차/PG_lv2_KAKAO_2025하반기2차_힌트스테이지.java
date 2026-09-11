package JAVA._COLLECTIONS.KAKAO._25.하반기_2차;

/**
 * [PG] KAKAO. 2025하반기2차 (lv2)
 * @category Brute-Force
 * @implNote
 * - 문제 요약   :
 * - 풀이 전략   : (Brute-Force) 단계마다 T or F로 완전 탐색. 모든 경우에 따른 비용 계산
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-06-27
 */
 
public class PG_lv2_KAKAO_2025하반기2차_힌트스테이지 {
	public static void main(String[] args){
	}

	class Solution {
		int N, K, min;
		int[][] cost, hint;
		public int solution(int[][] Cost, int[][] Hint) {
			// input
			cost = Cost; hint = Hint;
			N = cost.length;
			K = hint[0].length-1;   // 번들에 들은 힌트 권 개수
			min = Integer.MAX_VALUE;

			// solve
			stage(0, 0);

			// output
			return min;
		}

		// 스테이지에서 힌트 번들 구매 할 지
		void stage(int idx, int flag) {
			if (idx == N-1) {
				calc(flag);
				return;
			}

			// (idx+1) 번째 스테이지에서 힌트 번들 구매 X
			stage(idx+1, flag);
			// 구매 O
			stage(idx+1, flag|(1<<idx));
		}

		// 힌트 번들 구매 선택 결과에 따른 해결 비용 계산
		void calc(int flag) {
			int sum = 0;
			// 사용된 번들에 대해 힌트권 개수 세기
			int[] hintCount = new int[N];

			// 구매한 힌트 번들 반영
			for (int i=0; i<N-1; i++) {
				if ((flag&(1<<i)) != 0) {
					sum+=hint[i][0];
					for (int k = 0; k<K; k++) {
						hintCount[hint[i][k+1]-1]++;
					}
				}
			}

			for (int i=0; i<N; i++) {
				// Array Out of Bounds Exception
				if (hintCount[i] >= N) hintCount[i] = N-1;
				sum += cost[i][hintCount[i]];
			}

			// 최소 비용 갱신
			if (min > sum) min = sum;
		}
	}
}
