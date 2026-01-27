package JAVA._Practice;

public class PG_lv1_문자열다루기기본 {
    public static void main(String[] args) {
    }

    class Solution {
        public boolean solution(String s) {
            if (s.length() != 4 && s.length() != 6) return false;

            try {
                Integer.parseInt(s);
            } catch(Exception e) {
                return false;
            }

            return true;
        }
    }
}
