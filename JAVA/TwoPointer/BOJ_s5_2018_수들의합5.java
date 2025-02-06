package JAVA.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @from BOJ
 * @index 2018
 * @title 수들의 합 5
 * @grade Silver 5
 * @classification 투 포인터
 * @solve
 */
public class BOJ_s5_2018_수들의합5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        while (endIndex < N) {
            if (sum < N) {
                sum += ++endIndex;
            } else if (sum > N) {
                sum -= startIndex++;
            } else {
                count++;
                sum += ++endIndex;
            }
        }
        System.out.println(count);
    }
}
