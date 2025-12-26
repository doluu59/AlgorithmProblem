package JAVA.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author      |   ysyoo
 * @platform    |   Baekjoon
 * @index       |   11052
 * @title       |   카드 구매하기
 * @link        |   https://www.acmicpc.net/problem/11052
 * @level       |   Silver 2
 * @approach    |   DP 기본 - bottom top 방식으로 n장을 살 때의 최대 가격을 구해감
 * @algorithm   |   DP
 * @technique   |
 */

public class BOJ_s1_11052_카드구매하기 {
    private static int n;
    private static int[] dpMaxPrice;        // i 개의 카드 모았을 때 최대 가격
    private static int[] packPrice; // i번째 카드팩의 가격

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        packPrice = new int[n+1];
        dpMaxPrice = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= n; i++) {
            packPrice[i] =Integer.parseInt(st.nextToken());
        }

        // solve - DP
        // 카드를 targetAmount장을 구매했을 때의 최대 가격을 구하기 위함.
        // n장을 사야할 때, n장 짜리 팩을 샀을 떄와, (n-1)
        for (int targetAmount = 1; targetAmount<=n; targetAmount++) {
            for (int i=targetAmount; i>0; i--) {
                dpMaxPrice[targetAmount] = Math.max(dpMaxPrice[targetAmount], dpMaxPrice[targetAmount-i]+ packPrice[i]);
            }
        }

        // output
        System.out.println(dpMaxPrice[n]);
    }
}
