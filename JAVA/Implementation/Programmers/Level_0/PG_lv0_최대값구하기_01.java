/**
 * @from Programmers
 * @index
 * @title 최대값 구하기(1)
 * @grade Level 0
 * @classification 단순 구현
 */

package JAVA.Implementation.Programmers.Level_0;

/**
 * @idea : 최대값과 두번쨰 최대값을 구해서 곱하기 (음수가 없기 떄문)
 * @시간복잡도 : O(N)
 */
public class PG_lv0_최대값구하기_01 {
    public int solution(int[] numbers) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int number: numbers) {
            if (number >= max) {
                secondMax = max;
                max = number;
            } else {
                if (number >= secondMax) {
                    secondMax = number;
                }
            }
        }

        answer = max * secondMax;
        return answer;
    }
}