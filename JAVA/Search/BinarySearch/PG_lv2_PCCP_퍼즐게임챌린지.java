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
            int minLevel = 1;   // 양수 제한
            // 숙련도 최대값 = diff 값 중 최대 : 가장 어려운 퍼즐도 한번에 풀 수 있으면 숙련도 더 높아져도 같은 시간 소요
            int maxLevel = Integer.MIN_VALUE;
            for (int diff : diffs) {
                if (diff > maxLevel) maxLevel = diff;
            }
            // Binary Search : 숙련도의 최대값과 최소값의 중간값으로 해결 가능한 지 판단 후 범위 줄이기
            while (minLevel <= maxLevel) {
                int level = (minLevel + maxLevel) / 2;  // 숙련도 중간값
                long time = times[0];
                // 소요 시간 계산
                for (int i=1; i<length; i++) {
                    if (diffs[i] <= level) {
                        time += times[i];
                    } else {
                        time += (diffs[i] - level) * (times[i] + times[i-1] ) + times[i];
                    }
                }
                // 미션 성공인지
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
