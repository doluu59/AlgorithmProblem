package JAVA.Implementation;

import java.util.Queue;
import java.util.ArrayDeque;

/**
 * @from Programmers
 * @index PCCP 기출문제 1번
 * @title 붕대감기
 * @grade Level1
 * @classification Implementation
 * @solve 간단 구현
 */
public class PG_lv1_PCCP_붕대감기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int answer = health; // 남은 체력
            final int endTime = attacks[attacks.length-1][0];

            Queue<int[]> attackQueue = new ArrayDeque<>();
            for (int[] attack: attacks) {
                attackQueue.offer(attack);
            }

            int bandageTime = 0;

            int[] upcomingAttack = attackQueue.poll();
            for (int t=0; t<=endTime; t++) {
                // 공격 당하기
                if (t==upcomingAttack[0]) {
                    answer -= upcomingAttack[1];
                    // 캐릭터 사망
                    if (answer <= 0) {
                        answer = -1;
                        break;
                    }
                    upcomingAttack = attackQueue.poll();
                    bandageTime = 0;
                } else {
                    // 붕대 감기
                    answer += bandage[1];   // 초당 회복
                    // 연속 붕대 - 추가 회복
                    if (++bandageTime == bandage[0]) {
                        answer += bandage[2];
                        bandageTime = 0;
                    }
                    // 최대 체력
                    if (answer > health) {
                        answer = health;
                    }
                }
            }

            return answer;
        }
    }
}
