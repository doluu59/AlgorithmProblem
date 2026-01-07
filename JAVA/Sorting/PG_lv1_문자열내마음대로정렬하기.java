package JAVA.Sorting;

import java.util.*;

public class PG_lv1_문자열내마음대로정렬하기 {
    public static void main(String[] args) {
    }

    class Solution {
        public String[] solution(String[] strings, int n) {
            int len = strings[0].length();

            Arrays.sort(strings, (a, b) -> {
                // n번째 문자 같을 경우 사전 순
                if (a.charAt(n) == b.charAt(n)) {
                    for (int i=0; i<len; i++) {
                        if (a.charAt(i) != b.charAt(i)) return a.charAt(i) - b.charAt(i);
                    }
                }
                // 다를 경우 n번째 글자 기준
                return a.charAt(n) - b.charAt(n);
            });

            return strings;
        }
    }
}
