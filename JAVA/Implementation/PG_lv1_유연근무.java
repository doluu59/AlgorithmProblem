package JAVA.Implementation;

/**
 * @from Programmers
 * @index 2025 프로그래머스 코드챌린지 1차 예선
 * @title 유연근무
 * @grade Level 1
 * @classification Implementation
 * @solve 단순 구현
 */
public class PG_lv1_유연근무 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int answer = 0;
            int n=schedules.length;
            for (int i=0; i<n; i++) {
                boolean isGoodPerson = true;
                for (int d=0; d<7; d++) {
                    if (isWeekdays(startday + d)) {     // 주중만
                        // 지각 한 번이라도 하면 false
                        if (!isOnTime(getMin(schedules[i]), getMin(timelogs[i][d]))) {
                            isGoodPerson = false;
                            break;
                        }
                    }
                }
                // 지각 안했으면 상품 획득
                if (isGoodPerson) answer++;
            }
            return answer;
        }
        // 목표 시간+10분까지 오면 good
        public boolean isOnTime(int target, int time) {
            return (target + 10 >= time);
        }
        // 평일인지
        public boolean isWeekdays(int day) {
            return (day % 7 != 0 && day % 7 != 6);
        }
        // 시간*100+분 단위의 시간을 분 단위로 바꾸기
        public int getMin(int time) {
            int hour = time/100;
            int min = time%100;
            return 60*hour+min;
        }
    }
}
