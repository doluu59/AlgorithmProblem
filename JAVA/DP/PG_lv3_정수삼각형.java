package JAVA.DP;

/**
 * @from Programmers
 * @index
 * @title 정수 삼각형
 * @grade Level 3
 * @classification DP
 * @solve 삼각형의 특정 포인트의 최대값은 이전 단계의 두개 중에 하나랑 합한 것
 */
public class PG_lv3_정수삼각형 {
    public static void main(String[] args) {
    }
    class Solution {
        public int solution(int[][] triangle) {
            int h = triangle.length;

            int answer = 0;

            // 끝에서부터 최대값으로 내려가기?
            for (int i=1; i<h; i++) {
                for (int j=0; j<triangle[i].length; j++) {
                    if (j==0) {
                        triangle[i][j] += triangle[i-1][j];
                        continue;
                    }

                    if (j==triangle[i].length-1) {
                        triangle[i][j] += triangle[i-1][j-1];
                        continue;
                    }

                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                }
            }
            int max = Integer.MIN_VALUE;
            for (int sum : triangle[h-1]) {
                max = sum > max ? sum : max;
            }
            return max;
        }
    }
}
