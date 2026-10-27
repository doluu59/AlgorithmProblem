package JAVA.SlidingWindow;

/**
 * [PG] 크기가작은부분문자열 | 연습 · Lv.1
 *
 * @category Sliding Window
 * @algorithm Sliding Window
 *
 * @implNote
 * - 문제 요약   : 문자열 t에서 p와 같은 길이의 부분 문자열 중 p보다 작거나 같은 숫자의 개수 구하기
 * - 풀이 전략   : 고정 길이의 윈도우를 한 칸씩 이동하며 이전 숫자에서 앞자리를 제거하고 새 자릿수를 추가
 * - 시간 복잡도 : O(n^2) (Substring) -> O(n) (Sliding Window)
 * - 탐구 과정   : substring()과 parseLong()을 반복하는 기존 방식은 각 윈도우마다 O(L)이 필요하여 O(N × L)이 된다.
 *                 이전 윈도우의 숫자를 활용하는 Sliding Window 방식으로 개선하면 윈도우 이동을 O(1)에 처리할 수 있다.
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/147355">크기가 작은 부분 문자열</a>
 */
 
public class PG_lv1_연습_크기가작은부분문자열 {
	public static void main(String[] args){
	}

	// Sliding Window ( O(n) )
	static class Solution {
		public int solution(String t, String p) {
			int len = p.length();                   						// 부분 문자열 길이
			long base = (long) Math.pow(10, len - 1);  					// sliding window 맨 앞자리를 제거하기 위한 기준값
			long window = Long.parseLong(t.substring(0, len));	// sliding window 초기화
			long target = Long.parseLong(p);
			int answer = window <= target ? 1 : 0;

			for (int i = len; i < t.length(); i++) {
				int next = t.charAt(i) - '0';
				window = (window % base) * 10 + next;
				if (window <= target) answer++;
			}
			return answer;
		}
	}

	/*
	// substring 활용 (O(n^2))
	static class Solution {
		public int solution(String t, String p) {
			int answer = 0;
			int l = p.length();

			long target = Long.parseLong(p);
			for (int i=0; i <= t.length()-l; i++) {
				long num = Long.parseLong(t.substring(i, i+l));
				if (num <= target) answer++;
			}

			return answer;
		}
	}
	*/
}
