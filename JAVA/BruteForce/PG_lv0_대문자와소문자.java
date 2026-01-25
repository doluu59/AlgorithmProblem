package JAVA.BruteForce;

public class PG_lv0_대문자와소문자 {
    public static void main(String[] args) {

    }

    class Solution {
        public String solution(String my_string) {
            StringBuffer sb = new StringBuffer();

            int dist = 'A' - 'a';
            for (int i=0; i<my_string.length(); i++) {
                char ch = my_string.charAt(i);
                if (ch >= 'a' && ch <= 'z') ch = (char)(ch + dist);
                else ch = (char)(ch - dist);
                sb.append(ch);
            }
            return sb.toString();
        }
    }
}
