package JAVA._Practice;

public class PG_lv0_n보다커질때까지더하기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] numbers, int n) {
                int answer = 0;
                for (int i=0; i<numbers.length; i++) {
                    answer += numbers[i];
                    if (answer > n) break;
                }
                return answer;
            }
        }
    }
}
