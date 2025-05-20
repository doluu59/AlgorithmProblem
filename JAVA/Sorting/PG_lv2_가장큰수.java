package JAVA.Sorting;

/**
 * @from Programmers
 * @index 알고리즘 고득점 Kit
 * @title 가장 큰 수
 * @grade Level 2
 * @classification Sorting
 * @solve 숫자를 문자열로 바꿔서, 문자열을 두개 붙였을 때, 큰 수가 앞으로 오게
 */

import java.util.*;

public class PG_lv2_가장큰수 {

    class Solution {
        public String solution(int[] numbers) {
            String[] strs = new String[numbers.length];
            for (int i=0; i<numbers.length; i++) {
                strs[i] = Integer.toString(numbers[i]);
            }

            // 큰 애가 앞에
            Arrays.sort(strs, (o1, o2) -> {
                    long a1 = Long.parseLong(o1+o2);
                    long a2 = Long.parseLong(o2+o1);
                    return (int)(a2-a1);
                }
            );

            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(str);
            }
            String answer = sb.toString();

            if (answer.charAt(0) == '0') answer = "0";
            return answer;
        }
    }
}
