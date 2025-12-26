package JAVA._COLLECTIONS.SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author      |   ysyoo
 * @platform    |   Baekjoon - 삼성 SW 역량 테스트 기출 문제
 * @index       |   Bronze 2
 * @title       |   시험 감독
 * @link        |   https://www.acmicpc.net/problem/13458
 * @level       |   Bronze 2
 * @approach    |   단순 계산
 * @algorithm   |   Math
 * @technique   |   사용된 기법 (Bit masking, stream ...)
 */

public class BOJ_b2_13458_시험감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] classroom = new int[N];
        int[] teacher = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            classroom[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<2; i++) {
            teacher[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;

        for (int student : classroom) {
            // 총 감독관
            student -= teacher[0];
            count++;

            if (student <= 0) continue;

            // 부 감독관
            count += student/teacher[1];
            if (student%teacher[1]!=0) count++;
        }

        System.out.println(count);
    }
}
