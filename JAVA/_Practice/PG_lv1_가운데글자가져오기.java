package JAVA._Practice;

public class PG_lv1_가운데글자가져오기 {
    public static void main(String[] args) {
    }

    class Solution {
        public String solution(String s) {
            StringBuffer sb = new StringBuffer();
            if (s.length() % 2 == 0) {
                sb.append(s.charAt(s.length()/2-1))
                        .append(s.charAt(s.length()/2));
            } else {
                sb.append(s.charAt(s.length()/2));
            }
            String answer = sb.toString();
            return answer;
        }
    }
}
