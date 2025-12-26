package JAVA._Practice;

public class PG_lv1_부족한금액계산하기 {
    public static void main(String[] args) {
    }

    class Solution {
        public long solution(int price, int money, int count) {
            long answer = 0;
            long sum = 0;
            for (int i=1; i<= count; i++) {
                sum += price*i;
            }

            answer = (sum - money) > 0 ? sum - money : 0;

            return answer;
        }
    }
}
