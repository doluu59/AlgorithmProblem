package JAVA._Practice;

public class PG_lv0_소문자로바꾸기 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String myString) {
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<myString.length(); i++) {
                    char c = myString.charAt(i);
                    if (c  >= 'A' && c <= 'Z') sb.append((char)(c-'A'+'a'));
                    else sb.append(c);
                }
                return sb.toString();
            }
        }
    }
}
