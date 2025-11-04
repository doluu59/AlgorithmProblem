package JAVA.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @platform        |   Baekjoon (code.plus 코딩 테스트 준비 - 기초 - DP Part 1)
 * @index           |   11053
 * @title           |   가장 긴 증가하는 부분 수열
 * @link            |   https://www.acmicpc.net/problem/11053
 * @level           |   silver 2
 * @algorithm       |   DP (LIS - 최장 증가 부분 수열)
 * @performance     |   O(n^2)
 * @description     |   LIS(최장 증가 부분 수열) 가장 기본
 * @technique       |   stream
 * @note            |   stream으로 배열 바꾸는 게 StringTokenizer보다 느리다..  
 */

public class BOJ_s2_11053_가장긴증가하는부분수열 {
    public static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        arr = Arrays.stream(br.readLine().split(" "))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
        
        
        // solve
        // LIS 구하기
        dp = new int[n];
        dp[0] = 1;
        for (int i=1; i<n; i++) {
            LIS(i);
        }

        // output
        int answer = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }

    public static int LIS(int n) {
        // 내 앞에 배열부터 차례대로 비교
        for (int i=n-1; i>=0; i--) {
            if(dp[i] != 0 && arr[n] > arr[i]) {
                dp[n] = Math.max(dp[i]+1, dp[n]);
            }
        }

        // 나보다 작은 애가 없어
        if (dp[n] == 0) dp[n] = 1;

        return dp[n];
    }
}
