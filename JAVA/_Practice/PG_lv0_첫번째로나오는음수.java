package JAVA._Practice;

public class PG_lv0_첫번째로나오는음수 {
    public static void main(String[] args) {
    }

    class Solution {
        public int solution(int[] num_list) {
            for (int i=0; i<num_list.length; i++) {
                if (num_list[i] < 0) return i;
            }
            return -1;
        }
    }
}
