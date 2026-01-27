package JAVA._Practice;

public class PG_lv0_문자열의뒤의n글자 {
    public static void main(String[] args) {

    }

    class Solution {
        public String solution(String my_string, int n) {
            return  my_string.substring(my_string.length()-n);
        }
    }
}
