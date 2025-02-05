package JAVA.TwoPointer.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @from BOJ
 * @index 1940
 * @title 주몽
 * @grade Silver 4
 * @classification 투 포인터
 * @solve 두 개 골라서 합 맞추기.
 *         정렬해서 투 포인터로 할 수도 있다.
 */
public class BOJ_s4_1940_주몽 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ingredients = new int[N];
        for (int i=0; i<N; i++) {
            ingredients[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        int count = 0;
        for (int si = 0; si < N-1; si++) {
            for (int ei = si+1; ei < N; ei++) {
                if (ingredients[si] >= M) break;
                if (ingredients[si] + ingredients[ei] == M) {
                    count++;
                    break;
                }
            }
        }
        // output
        System.out.println(count);
    }
}
