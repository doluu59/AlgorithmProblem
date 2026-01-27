package JAVA._Practice;

public class PG_lv0_개미군단 {
    public static void main(String[] args) {
    }

    class Solution {
        public int solution(int hp) {
            int answer = 0;
            answer += hp/5;
            hp %= 5;
            answer += hp/3;
            answer += hp%3;

            return answer;
        }
    }
}
