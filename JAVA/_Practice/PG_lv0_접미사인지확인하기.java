package JAVA._Practice;

public class PG_lv0_접미사인지확인하기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(String my_string, String is_suffix) {
                if (is_suffix.length() > my_string.length()) return 0;

                int answer = 1;
                int diff = my_string.length() - is_suffix.length();
                for (int i=is_suffix.length()-1; i>=0; i--) {
                    if (my_string.charAt(i+diff) != is_suffix.charAt(i)) {
                        answer = 0;
                        break;
                    }
                }
                return answer;
            }
        }
    }
}
