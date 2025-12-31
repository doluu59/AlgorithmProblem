package JAVA._Practice;

public class PG_lv1_핸드폰번호가리기 {
    public static void main(String[] args) {
    }

    static class Solution {
        public String solution(String phone_number) {
            int len = phone_number.length();
            StringBuffer sb = new StringBuffer();
            for (int i=0; i<len-4; i++) {
                sb.append("*");
            }
            for (int i=len-4; i<len; i++) {
                sb.append(phone_number.charAt(i));
            }
            String answer = sb.toString();
            return answer;
        }
    }
}
