package JAVA._Practice;

public class PG_lv0_문자열정수의합 {
    public static void main(String[] args) {
        class Solution {
            public int solution(String num_str) {
                int answer = 0;
                for (int i=0; i<num_str.length(); i++) {
                    answer += (int)(num_str.charAt(i) - '0');
                }
                return answer;
            }
        }
    }
}
