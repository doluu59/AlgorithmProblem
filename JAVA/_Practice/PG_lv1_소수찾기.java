package JAVA._Practice;

public class PG_lv1_소수찾기 {
    public static void main(String[] args) {
    }

    class Solution {
        public int solution(int n) {
            int answer = 0;

            for (int i=2; i<=n; i++) {
                if (isPrime(i)) answer++;
            }
            return answer;
        }

        public boolean isPrime(int num) {
            if (num==2 || num==3) return true;

            for (int i=2; i<=Math.sqrt(num); i++) {
                if (num%i == 0) return false;
            }

            return true;
        }
    }
}
