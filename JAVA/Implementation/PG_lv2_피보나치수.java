package JAVA.Implementation;

/**
 * @from
 * @index
 * @title
 * @grade
 * @classification
 * @solve
 */
public class PG_lv2_피보나치수 {
    public static void main(String[] args) {
    }

    class Solution {
        public int solution(int n) {
            int[] fib = new int[n+1];
            fib[1] = 1;
            for (int i=2; i<=n; i++) {
                // n번째 피보나치 수가 long 범위도 넘을 수 있기 때문에 나머지를 미리 해주어야 한다.
                fib[i] = (fib[i-1] + fib[i-2])%1234567;
            }

            int answer = fib[n];
            return answer;
        }
    }
}
