package JAVA.DataStructure.PriorityQueue;

/**
 * [PG] 명예의 전당 (1) | 연습 · Lv.1
 *
 * @category Data Structure
 * @algorithm Priority Queue (Min Heap)
 *
 * @implNote
 * - 문제 요약   : 매일 발표된 점수 중 상위 K개의 점수를 명예의 전당에 유지하고 최하위 점수 기록하기
 * - 풀이 전략   : 최소 힙을 사용하여 상위 K개의 점수만 유지
 *                 점수를 삽입한 후 크기가 K를 초과하면 최솟값을 제거
 *                 힙의 최솟값을 매일의 명예의 전당 최하위 점수로 기록
 * - 시간 복잡도 : O(N log K) (N = 점수 개수, K = 명예의 전당 최대 인원)
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/138477">명예의 전당 (1)</a>
 */

import java.util.*;

public class PG_lv1_연습_명예의전당1 {
	public static void main(String[] args){
	}

	static class Solution {
		public int[] solution(int k, int[] score) {
			int[] answer = new int[score.length];
			PriorityQueue<Integer> pq = new PriorityQueue<>();

			for (int i=0; i<score.length; i++) {
				pq.offer(score[i]);
				if (pq.size() > k) pq.poll();
				answer[i] = pq.peek();
			}
			return answer;
		}
	}
}
