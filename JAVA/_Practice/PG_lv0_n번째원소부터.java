package JAVA._Practice;

public class PG_lv0_n번째원소부터 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] num_list, int n) {
                int len = num_list.length;
                int[] answer = new int[len-n+1];

                for (int i=n-1; i<len; i++) {
                    answer[i-n+1] = num_list[i];
                }
                return answer;
            }
        }
    }
}
