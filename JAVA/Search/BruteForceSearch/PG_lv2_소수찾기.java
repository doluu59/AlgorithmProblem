package JAVA.Search.BruteForceSearch;

/**
 * @from Programmers
 * @index 알고리즘 고득점 Kit - 완전 탐색
 * @title 소수 찾기
 * @grade Level 2
 * @classification Brute Force
 * @solve 숫자열을 사용해서 만들 수 있는 숫자 조합을 순열로 찾고, 소수인지 판별
 */

import java.util.*;

public class PG_lv2_소수찾기 {
    class Solution {
        int n;
        char[] chars;
        Set<Integer> set;   // 만든 숫자들 안겹치게 Set

        public int solution(String numbers) {
            n = numbers.length();
            chars = new char[n];
            for (int i=0; i<n; i++) {
                chars[i] = numbers.charAt(i);
            }
            set = new HashSet<Integer>();

            // 숫자 만들기
            perm(0, "", 0);

            int answer = 0;
            for (Integer num : set) {
                if (isPrime(num)) answer++;
            }
            return answer;
        }

        public void perm (int len, String str, long flag) {
            // 숫자 길이가 1~n까지
            if (len <= n && len > 0) {
                int num = Integer.parseInt(str);
                set.add(num);
            }

            for (int i=0; i<n; i++) {
                // 이미 사용한 숫자면 빼고
                if ((flag&(1<<i)) != 0) continue;
                // 새로운 숫자 조합 만들어서 재귀
                perm(len+1, str+chars[i], flag|(1<<i));
            }
        }

        // 소수 판별
        public boolean isPrime(int n) {
            if (n <= 1) return false;

            if (n==2 || n==3) return true;

            for (int i=2; i<=Math.sqrt(n); i++) {
                if (n%i == 0) return false;
            }

            return true;
        }
    }
}
