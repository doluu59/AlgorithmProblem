package JAVA.DP;

import java.io.*;
import java.util.*;

/**
 * @author      |   ysyoo
 * @platform    |   Baekjoon
 * @index       |   14002
 * @title       |   가장 긴 증가하는 부분 수열 4
 * @link        |   https://www.acmicpc.net/problem/14002
 * @level       |   Gold 4
 * @approach    |   LIS의 길이를 DP로 구한 후, Top - Down 방식으로 LIS를 복원
 * @algorithm   |   DP
 * @technique   |
 */

public class BOJ_g4_14002_가장긴증가하는부분수열4 {
    private static int[] arr, dp;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        dp = new int[N];
        Arrays.fill(dp, 1);

        int max = dp[0];    // LIS 길이
        int maxIdx = 0;        // LIS의 끝 숫자의 index

        // LIS의 길이 세기
        for (int i=1; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // LIS의 길이랑 좌표 저장
            if (dp[i] > max) {
                max = dp[i];
                maxIdx = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append(max+"\n");

        int[] lis = new int[max];
//        lis[max-1] = arr[maxIdx];

        int len = max;
        for (int i=maxIdx; i>=0; i--) {
            if (dp[i] == len) {
                lis[len-1] = arr[i];
                len--;
            }
        }

        // 스택 사용
//        Stack<Integer> stack = new Stack<>();
//        for (int i=idx; i>=0; i--) {
//            if (dp[i] == len) {
//                stack.push(arr[i]);
//                len--;
//            }
//        }
//
//        int i = 0;
//        while(!stack.isEmpty()) {
//            lis[i] = stack.pop();
//            i++;
//        }

        //output
        for (int e: lis) {
            sb.append(e);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
