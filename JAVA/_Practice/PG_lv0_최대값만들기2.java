package JAVA._Practice;

import java.util.*;

public class PG_lv0_최대값만들기2 {
    public static void main(String[] args) {
    }

    class Solution {
        public int solution(int[] numbers) {
            // 원래는 nC2 조합으로 곱하기
            int n = numbers.length;
            Arrays.sort(numbers);

            // 정렬 후 음수 중 가장 절대값 큰 2개와 양수 중 가장 큰 2개 비교하기
            // 다 양수거나 0껴있어도 오름차순이라 상관없음
            int n1 = numbers[0]*numbers[1];
            int n2 = numbers[n-1]*numbers[n-2];

            int answer = n1 > n2 ? n1 : n2;
            return answer;
        }
    }
}
