package JAVA._Practice;

public class PG_lv0_문자열의앞의n글자 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String my_string, int n) {
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<n; i++) {
                    sb.append(my_string.charAt(i));
                }
                return sb.toString();
            }
        }
    }
}
