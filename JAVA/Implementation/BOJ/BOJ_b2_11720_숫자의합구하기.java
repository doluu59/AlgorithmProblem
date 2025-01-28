package JAVA.Implementation.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @from Backjoon Online Judge
 * @index 11720
 * @title 숫자의 합 구하기
 * @grade Bronze 2
 * @classification Implementation
 * @solve String의 split() 메서드 활용. 단순 반복문
 */
public class BOJ_b2_11720_숫자의합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        String[] nums = br.readLine().split("");
        for (int i = 0; i<N; i++) {
            sum += Integer.parseInt(nums[i]);
        }
        System.out.println(sum);
    }
}
