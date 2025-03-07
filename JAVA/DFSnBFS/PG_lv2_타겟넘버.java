package JAVA.DFSnBFS;

/**
 * @from Programmers
 * @index High Score Kit
 * @title 타겟 넘버
 * @grade level 2
 * @classification dfs, permutation
 * @solve 순열처럼 해당 idx를 사용했을 때, 안했을 때와 같이 +와 -로 재귀를 두번.
 */
public class PG_lv2_타겟넘버 {
    static int[] nums;
    static int t, answer;

    public int main(int[] numbers, int target) {
            nums = numbers;
            t=target;
            answer = 0;

            perm(0, 0);

            return answer;
        }

    public static void perm(int idx, int value) {
        if (idx == nums.length) {
            if (value == t) answer++;
            return;
        }

        // 순열과 비슷하게 +했을 때와 -했을 때로 나눠서 재귀
        perm(idx+1, value+nums[idx]);
        perm(idx+1, value-nums[idx]);
    }
}


