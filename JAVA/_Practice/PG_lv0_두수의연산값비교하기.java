package JAVA._Practice;

public class PG_lv0_두수의연산값비교하기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int a, int b) {
                int num = Integer.parseInt(String.valueOf(a)+String.valueOf(b));
                return Math.max(num, 2*a*b);
            }
        }
    }
}
