package JAVA.Mathematics.Date;

/**
 * [PG] 2016년 | 연습 · Lv.1
 *
 * @category Mathematics
 * @algorithm Date Calculation
 *
 * @implNote
 * - 문제 요약   : 2016년의 특정 날짜를 입력받아 해당 날짜의 요일 구하기
 * - 풀이 전략   : 윤년인 2016년의 월별 날짜 수를 배열에 저장
 *                 입력된 월 이전까지의 날짜 수와 해당 월의 날짜를 누적
 *                 누적 일수를 7로 나눈 나머지를 이용하여 요일 계산
 * - 시간 복잡도 : O(1) (월별 날짜 수 배열 순회)
 *
 * @author   ysyoo
 * @see      <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12901">2016년</a>
 */
 
public class PG_lv1_연습_2016년 {
	static class Solution {
		public String solution(int a, int b) {
			String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
			int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			int date = 0;

			// 지난 월의 날짜 수
			for (int i = 0; i < a; i++) {
				date += month[i];
			}
			// 남은 일
			date += b;

			return day[date % 7];
		}
	}
}
