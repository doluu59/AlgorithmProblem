package JAVA._Practice;

public class PG_lv0_글자이어붙여문자열만들기 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String my_string, int[] index_list) {
                StringBuilder sb = new StringBuilder();
                for(int index : index_list) {
                    sb.append(my_string.charAt(index));
                }
                return sb.toString();
            }
        }
    }
}
