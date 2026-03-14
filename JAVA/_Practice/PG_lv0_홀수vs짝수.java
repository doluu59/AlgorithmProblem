package JAVA._Practice;

public class PG_lv0_홀수vs짝수 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] num_list) {
                int answer = 0;
                int[] sum = new int[2];
                for (int i=0; i<num_list.length; i++) {
                    if (i%2==0) sum[0] += num_list[i];
                    else sum[1] += num_list[i];
                }
                answer = Math.max(sum[0], sum[1]);
                return answer;
            }
        }
    }
}
