package JAVA._Practice;

public class PG_lv0_더크게합치기 {
    public static void main(String[] args) {

    }

    class Solution {
        public int solution(int a, int b) {
            int answer = 0;
            String str1 = Integer.toString(a)+Integer.toString(b);
            String str2 = Integer.toString(b)+Integer.toString(a);

            int a1 = Integer.parseInt(str1);
            int a2 = Integer.parseInt(str2);
            answer = a1 > a2? a1 : a2;
            return answer;
        }
    }
}
