package JAVA._Practice;

public class PG_lv1_수박수박수박수박수 {
    public static void main(String[] args) {
    }

    class Solution {
        public String solution(int n) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<n; i++) {
                if (i%2 == 0) sb.append("수");
                else sb.append("박");
            }
            return sb.toString();
        }
    }
}
