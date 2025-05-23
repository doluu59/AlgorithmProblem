package JAVA.Sorting;

/**
 * @from Programmers
 * @index 알고리즘 고득점 Kit - 정렬
 * @title H-Index
 * @grade Level 3
 * @classification 정렬
 * @solve 정렬 후, n의 최솟값을 구함 (n = h번 이상 인용된 논문의 수, h = i번째 배열 값이면, n = length - i)
 */

import java.util.*;

public class PG_lv3_HIndex {
    class Solution {
        public int solution(int[] citations) {
            int answer = 0;

            // 오름차순 정렬
            Arrays.sort(citations);

            for (int n=citations.length; n>0; n--) {
                // h번 이상 인용된 논문 수가 n개
                int h = citations[citations.length-n];
                // n의 최솟값이 H-Index
                if (h >= n) {
                    answer = n;
                    break;
                }
            }
            return answer;
        }
    }
}
