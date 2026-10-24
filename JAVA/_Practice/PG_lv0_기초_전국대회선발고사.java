package JAVA._Practice;

/**
 * [PG] 기초. 전국대회선발고사 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 3.
 */

import java.util.*;

public class PG_lv0_기초_전국대회선발고사 {
	public static void main(String[] args){
	}

	static class Solution {
		public int solution(int[] rank, boolean[] attendance) {

			// 참석 가능한 학생들의 번호와 랭크를 담는 리스트
			List<int[]> list = new ArrayList<>();

			for(int i = 0; i < rank.length; i++) {
				if(attendance[i]) list.add(new int[] {i, rank[i]});
			}

			// 랭크를 기준으로 올림차순 정렬
			Collections.sort(list, (o1, o2) -> o1[1] - o2[1]);

			int answer = 10000 * list.get(0)[0] + 100 * list.get(1)[0] + list.get(2)[0];
			return answer;
		}
}
