package JAVA._Practice;

public class PG_lv0_팩토리얼 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int n) {
                int num=1; int i=1;
                while (num <= n) {
                    num *= ++i;
                }
                i--;
                return i;
            }
        }
    }
}
