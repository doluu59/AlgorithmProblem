package JAVA._COLLECTIONS.KAKAO;

/**
 * @author |   ysyoo
 * @platform |   Programmers
 * @index |   KAKAO 2025 하반기 1차
 * @title |   노란 신호등
 * @link |   https://school.programmers.co.kr/learn/courses/30/lessons/468371
 * @level |   Level 1
 * @approach |   겹치는 구간 찾기
 * @algorithm |   Simulation, Math (DP, Graph, Simulation ...)
 * @technique |   개선 사항 : limit를 최소공배수로하면 더 좋아
 */

public class PG_lv1_KAKAO_2025_노란불신호등 {
    public static void main(String[] args) {
        class Solution {
            // 매직 넘버 방지를 위한 상수 선언
            private static final int GREEN = 0;
            private static final int YELLOW = 1;
            private static final int RED = 2;

            public int solution(int[][] signals) {
                int n = signals.length;

                int limit = 1;  // 전체 신호등 켜지는 패턴의 한 사이클 길이 (이 시간 이후론 시작과 같은 패턴)
                int[] gyrCycle = new int[n];   // 각 신호등 켜지는 패턴의 한 사이클 길이
                for (int i = 0; i < n; i++) {
                    for (int time : signals[i]) {
                        gyrCycle[i] += time;
                    }
                    limit *= gyrCycle[i]; // 전체 탐색 범위
                }

                int[] counts = new int[limit + 1];  // i 초에 켜진 노란 신호등 개수
                // 신호등마다 노란 신호등 키기
                for (int i = 0; i < n; i++) {
                    int g = signals[i][GREEN];
                    int y = signals[i][YELLOW];

                    for (int cycle = 1; cycle <= limit; cycle += gyrCycle[i]) {
                        for (int yDur = 0; yDur < y; yDur++) {
                            int targetTime = cycle + g + yDur;
                            // [P1] 인덱스 초과 방지 로직 추가
                            if (targetTime <= limit) {
                                counts[targetTime]++;
                            }
                        }
                    }
                }

                int answer  = -1;
                for (int t = 1; t <= limit; t++) {
                    if (counts[t] == n) {
                        answer = t;
                        break;
                    }
                }

                return answer;
            }
        }
    }
}
