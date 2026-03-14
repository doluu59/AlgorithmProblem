package JAVA._Practice;

public class PG_lv0_날짜비교하기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] date1, int[] date2) {
                int answer = 0;
                if (date1[0] < date2[0]) return 1;
                if (date1[0] > date2[0]) return 0;

                if (date1[1] < date2[1]) return 1;
                if (date1[1] > date2[1]) return 0;

                if (date1[2] < date2[2]) return 1;

                return answer;
            }
        }
    }
}
