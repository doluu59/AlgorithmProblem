package JAVA._Practice;

public class PG_lv0_홀짝에따라다른값반환하기 {
    public static void main(String[] args) {
    }

    class Solution {
        public int solution(int n) {
            int answer = 0;

            if (n%2 != 0) {
                for (int i=1; i<=n; i++) {
                    answer += i%2 != 0 ? i : 0;
                }
            } else {
                for (int i=2; i<=n; i++) {
                    answer += i%2 == 0 ? i*i : 0;
                }
            }


            return answer;
        }
    }
}
