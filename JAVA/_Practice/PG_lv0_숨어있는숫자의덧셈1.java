package JAVA._Practice;

public class PG_lv0_숨어있는숫자의덧셈1 {
    public static void main(String[] args) {
    }

    class Solution {
        public int solution(String my_string) {
            int answer = 0;
            for (int i=0; i<my_string.length(); i++) {
                char ch = my_string.charAt(i);
                if (ch > '0' && ch <= '9') answer += ch-'0';
            }
            return answer;
        }
    }
}
