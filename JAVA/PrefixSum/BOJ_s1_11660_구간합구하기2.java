package JAVA.PrefixSum;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @from BaekJoon Online Judge
 * @index 11660
 * @title 구간 합 구하기2
 * @grade Silver 1
 * @classification 구간합
 * @solve 2차원 구간합을 구하는 공식이 중요
 */
public class BOJ_s1_11660_구간합구하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // input
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] nums = new int[N+1][N+1];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=N; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
//                System.out.print(nums[i][j]+" ");
            }
//            System.out.println();
        }
        // prefix sum
        int[][] sums = new int[N+1][N+1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                sums[i][j] = sums[i][j-1] + sums[i-1][j] - sums[i-1][j-1] + nums[i][j];
//                System.out.print(sums[i][j]+" ");
            }
//            System.out.println();
        }
        // solve
        int y1, x1, y2, x2, ans;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            y1 = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());

            // 답 구하는 공식
            ans = sums[y2][x2] - sums[y2][x1-1] - sums[y1-1][x2] + sums[y1-1][x1-1];
//            System.out.println(ans);
            bw.write(ans+"\n");
        }
        bw.flush();
        bw.close();
    }
}
