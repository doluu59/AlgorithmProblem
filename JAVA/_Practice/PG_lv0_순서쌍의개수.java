package JAVA._Practice;

public class PG_lv0_순서쌍의개수 {
    public static void main(String[] args) {
    }
    class Solution {
        public int solution(int n) {
            int answer = 0;
            for (int i=1; i<=Math.sqrt(n); i++) {
                if (i==Math.sqrt(n)) {
                    answer++;
                    break;
                }
                if (n%i == 0) answer+=2;
            }
            return answer;
        }
    }
}
