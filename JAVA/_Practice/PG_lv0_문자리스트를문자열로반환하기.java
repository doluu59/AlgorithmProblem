package JAVA._Practice;

public class PG_lv0_문자리스트를문자열로반환하기 {
    public static void main(String[] args) {

    }

    class Solution {
        public String solution(String[] arr) {
            StringBuilder sb = new StringBuilder();
            for(String str : arr) sb.append(str);
            return sb.toString();
        }
    }
}
