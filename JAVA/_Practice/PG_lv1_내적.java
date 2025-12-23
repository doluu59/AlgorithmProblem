package JAVA._Practice;

public class PG_lv1_내적 {
    public static void main(String[] args) {
    }

    class Solution {
        public long solution(int[] a, int[] b) {
            long answer = 0;
            for (int i=0; i<a.length; i++) {
                answer += a[i]*b[i];
            }
            return answer;
        }
    }
}
