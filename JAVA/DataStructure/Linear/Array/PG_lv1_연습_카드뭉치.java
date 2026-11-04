package JAVA.DataStructure.Linear.Array;

/**
 * [PG] 카드 뭉치 | 연습 · Lv.1
 *
 * @category Array
 * @algorithm Two Pointers
 *
 * @implNote
 * - 문제 요약   : 두 카드 뭉치에서 순서를 유지하며 카드를 꺼내 원하는 단어 배열 완성하기
 * - 풀이 전략   : 각 카드 뭉치의 현재 위치를 가리키는 인덱스 두 개 사용
 *                 goal의 단어와 각 인덱스가 가리키는 카드 비교
 *                 일치하는 카드의 인덱스만 증가시키고, 모두 일치하지 않으면 완성 불가
 * - 시간 복잡도 : O(G) (G = goal의 길이)
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/159994">카드 뭉치</a>
 */

public class PG_lv1_연습_카드뭉치 {
	static class Solution {
		public String solution(String[] cards1, String[] cards2, String[] goal) {
			int idx1 = 0;
			int idx2 = 0;

			for (String word : goal) {
				if (idx1 < cards1.length && word.equals(cards1[idx1])) {
					idx1++;
				} else if (idx2 < cards2.length && word.equals(cards2[idx2])) {
					idx2++;
				} else {
					return "No";
				}
			}

			return "Yes";
		}
	}
}
