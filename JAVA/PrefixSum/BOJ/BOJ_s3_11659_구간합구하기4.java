package JAVA.PrefixSum.BOJ;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @from Backjoon Online Judge
 * @index 11659
 * @title 구간 합 구하기4
 * @grade Silver 3
 * @classification 구간 합
 * @solve 구간 합을 재귀와 단순 반복문으로 구할 수 있다.
 */
public class BOJ_s3_11659_구간합구하기4 {
    public static int[] prefixSumArr;   // prefrixSumArr[i] == 0부터 i까지 구간의 합
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // prefix sum
        prefixSumArr = new int[N];
        // 재귀로 구하는 방법
        getPrefixSum(N-1);
        // 단순 반복문으로 구간 합 구하는 방법 (O(n))
//        prefixSumArr[0] = arr[0];
//        for (int i=1; i<N; i++) {
//            prefixSumArr[i] = prefixSumArr[i-1] + arr[i];
//        }

        // output
        int i, j, ans;
        for (int k=0; k<M; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            i = Integer.parseInt(st.nextToken()) -1;
            j = Integer.parseInt(st.nextToken()) -1;

            ans = i==0 ? prefixSumArr[j] : prefixSumArr[j] - prefixSumArr[i-1];
            bw.write(ans+"\n");
        }
        bw.flush();
        bw.close();
    }

    // 재귀로 구간 합 구하기
    public static int getPrefixSum(int n) {
        if (n == 0) {
            prefixSumArr[0] = arr[0];
            return prefixSumArr[0];
        }

        prefixSumArr[n] = getPrefixSum(n-1) + arr[n];
        return prefixSumArr[n];
    }
}
