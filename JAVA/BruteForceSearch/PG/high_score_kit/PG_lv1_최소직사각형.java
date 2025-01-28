/**
 * @from Programmers
 * @index
 * @title 최소 직사각형
 * @grade Level 1
 * @classification 완전 탐색
 */

package JAVA.BruteForceSearch.PG.high_score_kit;

public class PG_lv1_최소직사각형 {
    public long solution(int[][] sizes) {
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        for (int[] card : sizes) {
            x = Math.max(x, Math.max(card[0], card[1]));
            y = Math.max(y, Math.min(card[0], card[1]));
        }
        return (long) x * y;
    }
}
