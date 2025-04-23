package JAVA.Sorting;

import java.util.*;

/**
 * @from Programmers
 * @index 알고리즘 고득점 Kit - Hash
 * @title 전화번호 목록
 * @grade Level 2
 * @classification Sorting, Hash?
 * @solve 정렬한 후, 앞 뒤만 비교해서 시간복잡도를 n^2에서 n으로 줄이는 게 핵심
 */

public class PG_lv2_전화번호목록 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            Arrays.sort(phone_book);
            for (int i=0; i<phone_book.length-1; i++) {
                if (phone_book[i+1].startsWith(phone_book[i])) {
                    answer = false;
                    break;
                }
            }

            return answer;
        }
    }
}
