package JAVA.Search.BinarySearch;

/**
 * @from Programmers
 * @index High Score Kit
 * @title 입국심사
 * @grade Level 3
 * @classification Binary Search
 * @solve   걸리는 시간의 최소 시간과 최대 시간을 구해서 중간값으로 이분 탐색
 *          Long 타입 이용이 중요
 */
public class PG_lv3_입국심사 {
    public static void main(String[] args) {
    }

    public long solution(int n, int[] times) {
        long answer = 0;

        // 걸릴 수 있는 최대 시간과 최소 시간의 중간 값으로 이분탐색
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int time : times) {
            if (time > max) max = (long)time;
            if (time < min) min = (long)time;
        }
        min = min*(n/times.length);     // 모든 심사대가 최소 시간 걸릴 때 총 소요 시간
        max = max*(n/times.length);     // 모든 심사대가 최대 시간 걸릴 때 총 소요 시간

        // 이분 탐색
        while (min <= max) {
            long mid = (max+min)/2;     // 걸릴 수 있는 시간 범위의 중간 값
            long sum = 0;               // 각 심사대에서 심사한 사람 수의 합
            for (int time : times) {
                sum += mid/time;        // 중간값의 시간 동안 각 심사대에서 심사한 사람 수
            }
            if (sum >= n) {             // 심사해야 할 사람보다 많이 심사함. 시간 줄여도 됨
                max = mid - 1;
            } else {                    // 시간 늘려야 함
                min = mid + 1;
            }
        }
        return min;
    }
}