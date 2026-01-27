package JAVA._Practice;

public class PG_lv0_이어붙인수 {
    public static void main(String[] args) {

    }
    class Solution {
        public int solution(int[] num_list) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int num : num_list) {
                if (num%2==1) sb1.append(num);
                else sb2.append(num);
            }
            int answer = Integer.parseInt(sb1.toString())+ Integer.parseInt(sb2.toString());
            return answer;
        }
    }
}
