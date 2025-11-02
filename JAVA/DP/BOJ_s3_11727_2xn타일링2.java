package JAVA.DP;

import java.util.Scanner;

/**
 * @from Baekjoon (code.plus 코딩 테스트 준비 - 기초 - DP Part 1)
 * @index 11727
 * @title 2xn 타일링 2
 * @grade silver 3
 * @classification DP
 * @solve 점화식 구하기 (직접 1부터 만들어보는 게 가장 보기 쉬움)
 *          1. n=3 부터, 마지막 두칸 크기로 생각해보기
 *          2. 마지막 두 칸을 만드는 경우는 가로 두개, 사각형 하나 -> 총 2개
 *              => (n-2) * 2
 *          3. 마지막 칸이 세로로 한칸이면 (n-1) 번 째 만드는 경우의 수와 동일
 *              => (n-1)
 */

public class BOJ_s3_11727_2xn타일링2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];

        // solve
        dp[1] = 1;
        if(n>1) dp[2] = 3;
        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-1]+dp[i-2]*2)%10_007;
        }

        // output
        int answer = dp[n];
        System.out.println(answer);
    }
}
