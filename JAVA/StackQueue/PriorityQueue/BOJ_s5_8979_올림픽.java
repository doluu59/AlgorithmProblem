package yoo.algorithm.JAVA.StackQueue.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @from BOJ
 * @index 8979
 * @title 올림픽
 * @grade Silver 5
 * @classification Priority Queue
 * @solve 국가의 금은동 개수를 하나의 객체로 만든 후, 객체를 비교할 수 있는 우선순위 큐 생성
 */
public class BOJ_s5_8979_올림픽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        // 국가의 우선순위 큐 생성
        PriorityQueue<Nation> pq = new PriorityQueue<>( (o1, o2) -> {
            if (o1.gold != o2.gold) return o2.gold - o1.gold;
            else {
                if (o1.silver != o2.silver) return o2.silver - o1.silver;
                else {
                    if (o1.bronze != o2.bronze) return  o2.bronze - o1.bronze;
                    else return o1.index - o2.index;
                }
            }
        });

        // input - 우선순위 큐에 국가 넣기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int[] nums = new int[4];
            for (int k=0; k<4; k++) {
                nums[k] = Integer.parseInt(st.nextToken());
            }
            pq.offer(new Nation(nums[0], nums[1], nums[2], nums[3]));
        }

        br.close();

        int rank = 1;
        int sameCnt = 0;
        Nation cur = pq.poll();
        int ans = M == cur.index ? 1 : 0;

        // get rank
        while(!pq.isEmpty() && ans==0) {
            Nation prev = cur;
            cur = pq.poll();

            // 공동 수상
            if (isSameRank(cur, prev)) {
                sameCnt++;
            } else {
                rank++;
                rank += sameCnt;
                sameCnt = 0;
            }

            if (cur.index == M) {
                ans = rank;
                break;
            }
        }

        System.out.println(ans);
    }

    public static boolean isSameRank(Nation o1, Nation o2) {
        return o1.gold == o2.gold && o1.silver == o2.silver && o1.bronze == o2.bronze;
    }

    public static class Nation {
        private int index;
        private int gold;
        private int silver;
        private int bronze;

        public Nation(int index, int gold, int silver, int bronze) {
            this.index = index;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}
