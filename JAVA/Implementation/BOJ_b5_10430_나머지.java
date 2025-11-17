package JAVA.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author |   ysyoo
 * @platform |   문제 출처 (Baekjoon / Programmers / LeetCode / Softeer ...)
 * @index |   문제 번호
 * @title |   제목
 * @link |   문제 링크
 * @level |   난이도 (Gold 5, Lv.2, Medium ...)
 * @approach |   한 줄 문제 요약
 * @algorithm |   Math
 * @technique |   사용된 기법 (Bit masking, stream ...)
 */
public class BOJ_b5_10430_나머지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[3];
        for (int i=0; i<3; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[4];
        ans[0] = (num[0]+num[1])%num[2];
        ans[1] =  ((num[0]%num[2]) + (num[1]%num[2]))%num[2];
        ans[2] = (num[0]*num[1])%num[2];
        ans[3] = ((num[0]%num[2]) * (num[1]%num[2]))%num[2];
        for (int answer : ans) {
            System.out.println(answer);
        }
    }
}
