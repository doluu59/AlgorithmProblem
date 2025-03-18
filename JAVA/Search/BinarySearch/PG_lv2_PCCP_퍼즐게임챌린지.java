package JAVA.Search.BinarySearch;

/**
 * @from
 * @index
 * @title
 * @grade
 * @classification
 * @solve
 */
public class PG_lv2_PCCP_퍼즐게임챌린지 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public int solution(int[] diffs, int[] times, long limit) {
            int answer = 0;
            int length = diffs.length;

            // idea : 이분탐색?
            // 중앙값 어케 고르지.. limit 값 ? diff 값? -> 가장 어려운 퍼즐도 한번에 풀 수 있으면 숙련도 더 높아져도 상관 X
            int minLevel = 1;
            int maxLevel = Integer.MIN_VALUE;
            for (int diff : diffs) {
                if (diff > maxLevel) maxLevel = diff;
            }
            while (minLevel <= maxLevel) {
                int level = (minLevel + maxLevel) / 2;
                long time = times[0];
                for (int i=1; i<length; i++) {
                    if (diffs[i] <= level) {
                        time += times[i];
                    } else {
                        time += (diffs[i] - level) * (times[i] + times[i-1] ) + times[i];
                    }
                }

                if (time <= limit) {    // clear
                    maxLevel = level - 1;
                } else {                // fail
                    minLevel = level + 1;
                }
            }

            answer = minLevel;
            return answer;
        }
    }

}
