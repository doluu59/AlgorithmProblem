package JAVA._Practice;

public class PG_lv0_특정한문자를대문자로바꾸기 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String my_string, String alp) {
                StringBuilder sb = new StringBuilder();
                char a = alp.charAt(0);
                for (int i=0; i<my_string.length(); i++) {
                    if (my_string.charAt(i) == a) sb.append((char)(a-'a'+'A'));
                    else sb.append(my_string.charAt(i));
                }
                return sb.toString();
            }
        }
    }
}
