package JAVA.Implementation;

/**
 * @from
 * @index
 * @title
 * @grade
 * @classification
 * @solve
 */

import java.util.*;

public class PG_lv2_JadenCase문자열만들기 {
    public static void main(String[] args) {
    }

    class Solution {
        public String solution(String s) {
            StringBuffer sb = new StringBuffer();
            boolean JCflag = true;

            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);

                // 띄어쓰기 처리
                if (c == ' ') {
                    sb.append(c);
                    JCflag = true;
                    continue;
                }

                // 첫 문자
                if (JCflag) {
                    if (c >= 'a' && c<= 'z') {
                        // c = (char) (c - 'a' + 'A');
                        c = Character.toUpperCase(c);
                    }
                    JCflag = false;
                } else {
                    if (c >= 'A' && c <= 'Z') {
                        // c = (char) (c - 'A' + 'a');
                        c = Character.toLowerCase(c);
                    }
                }
                sb.append(c);
            }

            String answer = sb.toString();
            return answer;
        }
    }
}