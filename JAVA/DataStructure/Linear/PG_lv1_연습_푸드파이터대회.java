package JAVA.DataStructure.Linear.Deque;

/**
 * [PG] 푸드 파이터 대회 | 연습 · Lv.1
 *
 * @category Data Structure
 * @algorithm Deque
 *
 * @implNote
 * - 문제 요약   : 두 선수가 동일한 순서와 양의 음식으로 대결할 수 있도록 배치하기
 * - 풀이 전략   : 음식 종류별 개수를 2로 나눈 몫만큼 덱의 양쪽 끝에 대칭적으로 삽입
 *                 가운데에 물(0)을 배치한 후 덱에서 순서대로 꺼내 문자열 생성
 * - 시간 복잡도 : O(N + F) (N = 음식 종류 수, F = 전체 음식 개수)
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/134240">푸드 파이터 대회</a>
 */

import java.util.*;

public class PG_lv1_연습_푸드파이터대회 {
	public static void main(String[] args){
	}

	static class Solution {
		public String solution(int[] food) {
			Deque<Integer> deque = new ArrayDeque<>();
			deque.offerFirst(0);

			for (int i=food.length-1; i>=0; i--) {
				for (int j=0; j<food[i]/2; j++) {
					deque.offerFirst(i);
					deque.offerLast(i);
				}
			}

			StringBuilder sb = new StringBuilder();
			while (!deque.isEmpty()) {
				sb.append(deque.pollFirst());
			}
			
			return sb.toString();
		}
	}
}
