package JAVA._Practice;

/**
 * @author |   ysyoo
 * @platform |   문제 출처 (Baekjoon / Programmers / LeetCode / Softeer ...)
 * @index |   문제 번호
 * @title |   제목
 * @link |   문제 링크
 * @level |   난이도 (Gold 5, Lv.2, Medium ...)
 * @approach |   한 줄 문제 요약
 * @algorithm |   문제 유형 (DP, Graph, Simulation ...)
 * @technique |   사용된 기법 (Bit masking, stream ...)
 */
public class PG_lv0_flag에따라다른값반환하기 {
    public static void main(String[] args) {
    }
    class Solution {
        public int solution(int a, int b, boolean flag) {
            return flag? a+b : a-b;
        }
    }
}
