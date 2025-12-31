package JAVA._Practice;

import java.util.*;

public class PG_lv1_문자열내림차순으로배치하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public String solution(String s) {
            // String to char[]
            char[] ch = new char[s.length()];
            for (int i=0; i<s.length(); i++) {
                ch[i] = s.charAt(i);
            }
            // Sorted asc
            Arrays.sort(ch);

            // Sort desc;
            StringBuffer sb = new StringBuffer();
            for (int i=s.length()-1; i>=0; i--) {
                sb.append(ch[i]);
            }
            String answer = sb.toString();
            return answer;
        }
    }
}
