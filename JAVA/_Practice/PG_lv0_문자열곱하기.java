package JAVA._Practice;


public class PG_lv0_문자열곱하기 {
    public static void main(String[] args) {
    }

    class Solution {
        public String solution(String my_string, int k) {
            StringBuffer sb = new StringBuffer();

            for (int i=0; i<k; i++) {
                sb.append(my_string);
            }
            return sb.toString();
        }
    }
}
