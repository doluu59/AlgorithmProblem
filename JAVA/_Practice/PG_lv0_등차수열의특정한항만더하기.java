package JAVA._Practice;

public class PG_lv0_등차수열의특정한항만더하기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int a, int d, boolean[] included) {
                int answer = 0;
                for (int i=0; i<included.length; i++) {
                    if (included[i]) answer += i * d + a;
                }
                return answer;
            }
        }
    }
}
