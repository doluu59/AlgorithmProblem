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
public class PG_lv0_원소들의곱과합 {
    public static void main(String[] args) {

    }

    class Solution {
        public int solution(int[] num_list) {
            long multiple = 1l;
            long sum = 0l;

            for (int i=0; i<num_list.length; i++) {
                multiple *= num_list[i];
                sum += num_list[i];
            }

            return sum*sum > multiple ? 1 : 0;
        }
    }
}
