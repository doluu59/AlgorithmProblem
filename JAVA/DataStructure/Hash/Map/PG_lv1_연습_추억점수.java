package JAVA.DataStructure.Hash.Map;

/**
 * [PG] 추억 점수 | 연습 · Lv.1
 *
 * @category Hash Map
 * @algorithm Hash Map
 *
 * @implNote
 * - 문제 요약   : 사진에 등장하는 인물들의 추억 점수를 합산하여 사진별 추억 점수 계산하기
 * - 풀이 전략   : HashMap에 이름을 Key, 추억 점수를 Value로 저장
 *                 각 사진에 등장하는 인물의 점수를 조회하여 누적 합산
 *                 등록되지 않은 인물은 0점으로 처리
 * - 시간 복잡도 : O(N + P) (N = 인물 수, P = 전체 사진 속 인물 수)
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/176963">추억 점수</a>
 */

import java.util.*;

public class PG_lv1_연습_추억점수 {
	static class Solution {
		public int[] solution(String[] name, int[] yearning, String[][] photo) {
			int[] answer = new int[photo.length];

			// Map input
			Map<String, Integer> map = new HashMap<>();
			for (int i=0; i<yearning.length; i++) {
				map.put(name[i], yearning[i]);
			}

			// solve
			for (int i=0; i<photo.length; i++) {
				for (int j=0; j<photo[i].length; j++) {
					answer[i] += map.containsKey(photo[i][j]) ? map.get(photo[i][j]) : 0;		// getOrDefault
				}
			}

			return answer;
		}
	}
}
