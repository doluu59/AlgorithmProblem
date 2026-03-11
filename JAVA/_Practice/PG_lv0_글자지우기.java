package JAVA._Practice;

public class PG_lv0_글자지우기 {
    public static void main(String[] args) {

        class Solution {
            public String solution(String my_string, int[] indices) {
                StringBuilder sb = new StringBuilder();
                boolean[] flag = new boolean[my_string.length()];

                for (int i=0; i<indices.length; i++) {
                    flag[indices[i]] = true;
                }

                for (int i=0; i<my_string.length(); i++) {
                    if (!flag[i]) sb.append(my_string.charAt(i));
                }

                return sb.toString();
            }
        }
    }
}
