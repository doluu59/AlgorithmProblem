package JAVA.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @from Baekjoon
 * @index 2579
 * @title 계단 오르기
 * @grade Silver 3
 * @classification DP
 * @solve DP - 가능한 경우의 수가 2개 밖에 없는 것을 인식해서 규칙 찾아야 함
 */
public class BOJ_s3_2579_계단오르기 {
    static int[] stair;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stair = new int[N+1];
        score = new int[N+1];
        Arrays.fill(score, -1);
        score[0] = 0;
        for (int i=1; i<=N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(dp(N));
    }

    public static int dp (int i) {
        if (i < 1) return 0;

        if (score[i] == -1) {
            // 현재 계단을 밟을 떄, 이전 패턴은 딱 두개
            // 1. 두 칸 앞 계단을 밟음.
            // 2. 한 칸 앞 계단을 밟았으면, 세칸 연속 못밟아서 3칸 앞 계단 밟고 2칸 앞 띄고, 1칸 앞 밟은 것
            score[i] = Math.max(dp(i-2), dp(i-3)+stair[i-1]) + stair[i];
        }

        return score[i];
    }
}
