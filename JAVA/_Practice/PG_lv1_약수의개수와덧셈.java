package JAVA._Practice;

public class PG_lv1_약수의개수와덧셈 {
    public static void main(String[] args) {
    }

    class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            for (int i=left; i<=right; i++) {
                if (isOdd(i)) answer-=i;
                else answer+=i;
            }
            return answer;
        }

        public boolean isOdd(int num) {
            // 제곱근이 정수이면 약수의 개수가 홀수, 아니면 짝수
            double sqrt = Math.sqrt(num);

            return (int) sqrt*sqrt == num;
        }
    }
}
