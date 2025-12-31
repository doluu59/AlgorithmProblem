package JAVA.DP;

import java.io.*;

/**
 * @from Baekjoon (code.plus 코딩 테스트 준비 - 기초 - DP Part 1)
 * @index 9095
 * @title 1,2,3 더하기
 * @grade silver 3
 * @classification DP
 * @solve 점화식 구하기 -> 도착지가 n 일 때, (n-1), (n-2), (n-3)까지 온 경우의 수를 합하기
 */

public class BOJ_s3_9095_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        // solve
        int[] dp = new int[11];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i=4; i<11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        //output
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = dp[n];
//            System.out.println(answer);
            bw.write(Integer.toString(answer));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
