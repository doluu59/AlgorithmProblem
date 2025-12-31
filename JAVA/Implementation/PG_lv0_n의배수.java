package JAVA.Implementation;

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
public class PG_lv0_n의배수 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public int solution(int num, int n) {
            int answer = 0;
            return num%n == 0? 1:0;
        }
    }
}
