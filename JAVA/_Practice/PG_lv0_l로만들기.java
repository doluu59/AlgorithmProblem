package JAVA._Practice;

public class PG_lv0_l로만들기 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String myString) {
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<myString.length(); i++) {
                    if (myString.charAt(i) < 'l') sb.append('l');
                    else sb.append(myString.charAt(i));
                }
                return sb.toString();
            }
        }
    }
}
