package JAVA.Greedy;

/**
 * [BOJ] 2839. 설탕배달 (S4)
 * @category Greedy, DP
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-17
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S4_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		//주어진 무게에서 사용할 수 있는 5kg 개수에 따라 전체 봉지 개수 세기
		for (int f=0;f<=N/5; f++ ) {			//5kg 사용한 개수에 따라 계산
			int remains = N-5*f;	//5키로 짜리 뺴고 남은 무게 => 3으로 나누어 떨어져야 함.
			int cnt = (remains%3==0)? remains/3+f : Integer.MAX_VALUE;	//현재 5kg 개수와 남은 무게를 3kg로 맞출 수 있으면 카운트
			min = cnt<min? cnt : min;					//최소값 갱신
		}
		min = (min == Integer.MAX_VALUE)? -1 : min;		//봉지 개수를 아예 못맞추면 -1로
		//output
		System.out.println(min);
	}
}
