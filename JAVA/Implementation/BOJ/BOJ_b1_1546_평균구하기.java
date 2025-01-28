package JAVA.Implementation.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @from Backjoon Online Judge
 * @index 1546
 * @title 평균
 * @grade Bronze 1
 * @classification Implemantation
 * @solve 최대값, 평균 구하기
 */
public class BOJ_b1_1546_평균구하기 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // 최대값 구하기
        int max = Integer.MIN_VALUE;
        for (int i=0; i<N; i++) {
            if (nums[i] > max) max = nums[i];
        }
        // 평균 구하기
        float sum = 0f;
        for (int i=0; i<N; i++) {
            sum += (float)(nums[i]*100)/max;
        }
        float avg = sum/N;
        // Output
        System.out.println(avg);
    }
}
