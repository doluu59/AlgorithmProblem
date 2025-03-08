package JAVA.Search.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @from Baekjoon
 * @index 1920
 * @title 수 찾기
 * @grade Silver 4
 * @classification Binary Search
 * @solve Binary Search 단순 구현
 */
public class BOJ_s4_1920_수찾기 {
    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // input
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // sort for binary search
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());
            // solve - binary search
            bw.write(binarySearch(target)+"\n");
        }

        // output
        bw.flush();
        bw.close();
    }

    public static int binarySearch(int target) {
        // 배열 범위 벗어나는 거 전처리
        if (arr[0] > target || arr[N-1] < target) return 0;

        int start = 0;
        int end = N-1;
        int pivot;

        // binary search
        while (start <= end) {
            pivot = (end+start)/2;
            if (target == arr[pivot]) return 1;

            if (target < arr[pivot]) {
                end = pivot-1;
            } else {
                start = pivot+1;
            }
        }
        return 0;
    }
}
