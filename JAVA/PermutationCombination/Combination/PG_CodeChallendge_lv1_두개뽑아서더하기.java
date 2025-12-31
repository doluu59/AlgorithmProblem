package JAVA.PermutationCombination.Combination;

/**
 * @author |   ysyoo
 * @platform |   Programmers
 * @index |   월간 코드 챌린지 시즌 1
 * @title |   두 개 뽑아서 더하기
 * @link |   https://school.programmers.co.kr/learn/courses/30/lessons/68644
 * @level |   Level 1
 * @approach |  조합
 * @algorithm |   조합
 * @technique |   Set, Combination
 */


import java.util.*;

public class PG_CodeChallendge_lv1_두개뽑아서더하기 {
    public static void main(String[] args) {
    }

    class Solution {
        boolean[] isChecked;
        int[] numbers;
        int N;
        HashSet<Integer> set;

        public int[] solution(int[] nums) {
            N = nums.length;
            isChecked = new boolean[N];
            numbers = nums;
            set = new HashSet<>();

            comb(0, 0);

            System.out.println(set.toString());
            int[] answer = new int[set.size()];
            int idx = 0;
            for (int num : set) {
                answer[idx++] = num;
            }
            Arrays.sort(answer);

            return answer;
        }

        public void comb(int idx, int cnt) {if (cnt == 2) {
            int sum = 0;
            for (int i=0; i<N; i++) {
                if (isChecked[i]) sum += numbers[i];
            }
            set.add(sum);

            return;
        }

            if (idx >= N) return;

            isChecked[idx] = true;
            comb(idx+1, cnt+1);
            isChecked[idx] = false;
            comb(idx+1, cnt);
        }
    }
}
