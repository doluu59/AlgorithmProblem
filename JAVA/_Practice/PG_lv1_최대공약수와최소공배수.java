package JAVA._Practice;

public class PG_lv1_최대공약수와최소공배수 {
    public static void main(String[] args) {
    }

    class Solution {
        public long[] solution(int n, int m) {
            // 두 수가 같으면, GCD와 LGM은 n
            if (n==m) return new long[]{ n, n };

            // get GCD (최대공약수) O(N);
            int small = n<m ? n : m;
            int big = small==n ? m : n;
            int gcd = -1;

            for (int i=small; i>0; i--) {
                if (small%i==0 && big%i==0) {
                    gcd = i;
                    break;
                }
            }

            // get LCM (최소공배수)
            long lcm = (long) small * big / gcd;

            return new long[] { gcd, lcm };
        }
    }
}
