package JAVA.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @from BOJ
 * @index 2293
 * @title 동전 1
 * @grade Gold 4
 * @classification DP
 * @solve   점화식 구하기. 동전의 종류와 금액에 따라 경우의 수 만들기
 *
 *          1. 동전 작은 종류부터 사용해서 경우의 수 늘리기
 *          2. price를 만드는 경우의 수는, (구하고자 하는 price - 동전의 값 )을 만드는 경우의 수를 더해주어야 함
 *          2. ex) 1원 5원 dp[6] = dp[6] (이건 1원에서 구해놓은 것) + dp[6-5] (이건 5원으로 구한 것)
 *
 *          참고 : https://lotuslee.tistory.com/113?category=848933
 */

public class BOJ_g4_2293_동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        // DP
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i=0; i<n; i++) {   // 모든 종류의 동전을 사용
            for (int price=coins[i]; price<=target; price++) {
                dp[price] += dp[price-coins[i]];    // 작은 단위의 돈을 사용해서 그 금액을 만들어보기
            }
        }

        // output
        int answer = dp[target];
        System.out.println(answer);
    }
}
