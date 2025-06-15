package JAVA.PermutationCombination.Permutation;

/**
 * @from Programmers
 * @index 알고리즘 고득점 Kit
 * @title 피로도
 * @grade Level 2
 * @classification Brute Force, Permutation
 * @solve 순열로 탐색 순서를 정한 후, 최대 탐색 수 찾기
 */

public class PG_lv2_피로도 {
    public static void main(String[] args) {
    }

    public static class Solution {
        public static int N, K;
        public static int[] sequence;
        public static int[][] d;
        public static int max;

        public int solution(int k, int[][] dungeons) {
            K = k; d = dungeons;
            N = dungeons.length;
            sequence = new int[N];
            max = Integer.MIN_VALUE;

            // 순열로 던전 탐색 순서 만들기 (최대 8개)
            perm(0, 0);

            return max;
        }

        public void perm(int idx, int flag) {
            // 던전 탐사 순열 완성
            if (idx == N) {
                // 순서대로 던전 가기
                int cnt = 0;
                int hp = K;
                for (int cur : sequence) {
                    if (hp >= d[cur][0]) {
                        hp -= d[cur][1];
                        cnt++;
                    }
                }
                // update max dungeons
                if (max < cnt) max = cnt;

                return;
            }

            // Permutation
            for (int i=0; i<N; i++) {
                if ((flag&1<<i) != 0) continue;

                sequence[idx] = i;
                perm(idx+1, flag|(1<<i));
            }
        }
    }
}
