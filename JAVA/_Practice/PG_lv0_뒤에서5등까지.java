package JAVA._Practice;

import java.util.Arrays;

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
public class PG_lv0_뒤에서5등까지 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] num_list) {
                Arrays.sort(num_list);
                int[] answer = new int[5];

                for (int i=0; i<5; i++) {
                    answer[i] = num_list[i];
                }
                return answer;
            }
        }
    }
}
