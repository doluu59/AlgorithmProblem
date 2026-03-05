package JAVA._Practice;

public class PG_lv0_배열만들기1 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int n, int k) {
                int[] answer = new int[n/k];
                for (int i=1; i<=answer.length; i++) {
                    answer[i-1] = k*i;
                }
                return answer;
            }
        }
    }
}
