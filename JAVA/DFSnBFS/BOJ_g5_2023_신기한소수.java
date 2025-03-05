package JAVA.DFSnBFS;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @from Backjoon
 * @index 2023
 * @title 신기한 소수
 * @grade Gold 5
 * @classification DFS, 정수론
 * @solve 한 자리 수부터 N 자리 수까지 소수인 수만 dfs로 다음 수 재귀 탐색
 */

public class BOJ_g5_2023_신기한소수 {
    static int N;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 한 자리 수 중 소수인 2, 3, 5, 7만 시작
        for (int i=1; i<10; i++) {
            switch (i) {
                case 2: case 3: case 5: case 7: {
                    dfs(i, 1);
                }
            }
        }

        // output
        bw.flush();
        bw.close();
    }

    public static void dfs(int num, int n) throws IOException {
        // N자리 수인 소수라면 정답에 저장
        // 메서드에 진입한 num은 모두 소수 (소수 판별은 이전 재귀 문에서 하고 왔음)
        if (n == N) {
            bw.write(num+"\n");
            return;
        }

        // n+1 자리 수의 숫자가 소수인지 판별
        for (int i=1; i<10; i++) {
            int nextNum = num*10 + i;
            // 소수면 다음 자리 숫자 탐색하러 dfs
            if (isPrime(nextNum)) {
                dfs(nextNum, n + 1);
            }
        }
    }

    public static boolean isPrime(int num) {
        for (int i=2; i<=(int) Math.sqrt(num); i++) {
            // 소수가 아님
            if (num%i == 0) {
                return false;
            }
        }
        // 모두 나누어 떨어지지 않으면 소수
        return true;
    }

}
