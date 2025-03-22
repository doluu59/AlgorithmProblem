package JAVA.Implementation;

/**
 * @from Programmers
 * @index 2022 Kakao Blind Recruitment
 * @title k진수에서 소수 개수 구하기
 * @grade Level 2
 * @classification Math
 * @solve 소수 구하기, k 진법 변환
 */
public class PG_KAKAO_2022_lv2_k진수에서소수개수구하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public int solution(int n, int k) {
            // k진법으로 변환
            String transNum = Long.toString(n, k);

            // 0으로 나누기
            String[] nums = transNum.split("0");

            int answer = 0;
            for (String num : nums) {
                if (num.equals("")) continue;   // 0이 연속이면 "" 나옴
                if (isPrime(num)) {             // 소수 판별
                    answer++;
                }
            }

            return answer;
        }

        public boolean isPrime(String str) {
            Long num = Long.parseLong(str);     // Int 범위 넘어가면 안돼서

            if (num <= 1) return false;
            if (num <= 3) return true;

            for (int i=2; i <= (int)Math.sqrt(num); i++) {
                if (num%i == 0) return false;
            }
            return true;
        }
    }
}
