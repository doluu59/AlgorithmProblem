package JAVA._Practice;

public class PG_lv0_접두사인지확인하기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(String my_string, String is_prefix) {
                if (is_prefix.length() > my_string.length()) return 0;

                int answer = 1;
                for (int i=0; i<is_prefix.length(); i++) {
                    if (my_string.charAt(i) != is_prefix.charAt(i)) {
                        answer = 0;
                        break;
                    }
                }
                return answer;
            }
        }
    }
}
