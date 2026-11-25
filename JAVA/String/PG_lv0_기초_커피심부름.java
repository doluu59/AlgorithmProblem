package JAVA.String;

/**
 * [PG] 커피 심부름 | 기초 · Lv.0
 *
 * @category String
 * @algorithm Substring Search
 *
 * @implNote
 * - 문제 요약   : 주문한 커피의 종류에 따라 가격을 계산하고 총금액 반환
 * - 풀이 전략   : 각 주문에 "latte"가 포함되어 있는지 확인하여
 *                카페라테는 5,000원, 그 외에는 4,500원으로 계산 후 합산
 * - 시간 복잡도 : O(N × L) - N은 주문 개수, L은 메뉴 문자열의 최대 길이
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181837">커피 심부름</a>
 */
 
public class PG_lv0_기초_커피심부름 {
	static class Solution {
		public int solution(String[] order) {
			int answer = 0;

			for (String menu : order) {
				int price = menu.contains("latte") ? 5000 : 4500;
				answer += price;
			}
			return answer;
		}
	}
}
