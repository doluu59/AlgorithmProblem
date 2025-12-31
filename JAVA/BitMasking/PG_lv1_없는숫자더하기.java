package JAVA.BitMasking;

/**
 * @from Programmers
 * @index 월간 코드 챌린지 시즌 3
 * @title 없는 숫자 더하기
 * @grade Level 1
 * @classification Bit Masking
 * @solve
 */

public class PG_lv1_없는숫자더하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public int solution(int[] numbers) {
            int answer = 0;
            int flag = 0;

            for (int num : numbers) {
                flag |= (1<<num);
            }

            for (int i=0; i<10; i++) {
                if ((flag&(1<<i)) == 0) answer += i;
            }

            return answer;
        }
    }
}
