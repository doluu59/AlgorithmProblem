package JAVA.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @from Baekjoon
 * @index 12865
 * @title 평범한 배낭
 * @grade Gold 5
 * @classification Dynamic Programming
 * @solve DP
 */
public class BOJ_g5_12865_평범한배낭 {
    public static int[] weight, value;
    public static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        weight = new int[N+1];
        value = new int[N+1];
        d = new int[N+1][K+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(d[i], -1);
        }

        // DP -
        int answer = dp(N, K);
        System.out.println(answer);
    }

    /**
     * @param i - index
     * @param w - 담을 수 있는 무게
     * @return i번쨰까지 물건을 담을 떄 느낄 수 있는 최대 가치
     */
    public static int dp(int i, int w) {
        // DP
        if (d[i][w] == -1) {
            if (weight[i] > w) {
                // 이번 물건 선택할 수가 없으니 이전 꺼랑 동일
                d[i][w] = dp(i-1, w);
            } else {
                // 이번 물건 선택 가능
                d[i][w] = Math.max(dp(i-1, w), value[i] + dp(i-1, w-weight[i]));
            }
        }

        return d[i][w];
    }
}
