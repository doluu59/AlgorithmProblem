package JAVA.Hash;

import java.util.*;

/**
 * @from Programmers
 * @index 알고리즘 고득점 Kit - Hash
 * @title 폰켓몬
 * @grade Level 1
 * @classification Set
 * @solve 배열을 Set에 넣기
 */
public class PG_lv1_폰켓몬 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int n: nums) {
                set.add(n);
            }

            if (set.size() > nums.length/2) answer = nums.length/2;
            else answer = set.size();

            return answer;
        }
    }
}
