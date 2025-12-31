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
import java.util.*;

public class PG_lv0_n의배수고르기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public int[] solution(int n, int[] numlist) {
            List<Integer> ansList = new ArrayList<>();

            for (int num : numlist) {
                if (num%n == 0) ansList.add(num);
            }

            int[] answer = new int[ansList.size()];
            for (int i=0; i<ansList.size(); i++) {
                answer[i] = ansList.get(i);
            }

            return answer;
        }
    }
}
