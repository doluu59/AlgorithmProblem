package JAVA.StackQueue.Queue;

import java.util.*;

/**
 * @from Programmers
 * @index 2022 kakao Blind Recruitment
 * @title 두 큐 합 같게 만들기
 * @grade Level 2
 * @classification Queue
 * @solve 작업 횟수의 최대를 얼마로 주는 지가 중요
 */
public class PG_Kakao_2022_Lv2_두큐합같게만들기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        static Queue<Integer>[] queue;
        static int n, answer;
        static long[] sums;
        public int solution(int[] queue1, int[] queue2) {
            answer = -1;
            n = queue1.length;

            queue = new ArrayDeque[2];
            for (int i=0; i<2; i++) {
                queue[i] = new ArrayDeque<Integer>();
            }
            sums = new long[2];
            for (int i=0; i<n; i++) {
                queue[0].offer(queue1[i]);
                sums[0]+=queue1[i];
                queue[1].offer(queue2[i]);
                sums[1]+=queue2[i];
            }
            // 합이 홀수면 같을 수가 없음
            if ((sums[0] + sums[1])%2 == 1) return -1;
            if (sums[0] == sums[1]) return 0;

            for (int i=1; i<= 3*(n-1); i++) {
                int bigQueue = sums[0] > sums[1] ? 0 : 1;   // 합이 더 큰 큐
                int smallQueue = bigQueue == 1 ? 0 : 1;     // 더 작은 큐
                int cur = queue[bigQueue].peek();           // 옮길 숫자

                // 작업
                sums[bigQueue] -= cur;
                sums[smallQueue] += cur;
                queue[smallQueue].offer(queue[bigQueue].poll());

                // 같은지 비교
                if (sums[0] == sums[1]) {
                    answer = i;
                    break;
                }
            }

            return answer;
        }
    }
}
