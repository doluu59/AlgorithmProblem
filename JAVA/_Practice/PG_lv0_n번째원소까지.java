package JAVA._Practice;

public class PG_lv0_n번째원소까지 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] num_list, int n) {
                int[] answer = new int[n];
                for (int i=0; i<n; i++) {
                    answer[i] = num_list[i];
                }
                return answer;
            }
        }
    }
}
