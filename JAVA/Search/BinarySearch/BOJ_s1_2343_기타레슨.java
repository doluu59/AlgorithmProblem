package JAVA.Search.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @from BaekJoon
 * @index 2343
 * @title 기타 레슨
 * @grade Silver 1
 * @classification Binary Search
 * @solve 디스크의 최소 크기와 최대 크기를 기준으로 이진 탐색을 하여 구하고자 하는 값을 찾아야 함.
 */
public class BOJ_s1_2343_기타레슨 {
    static int N, V;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        int sum = 0;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if (max < arr[i]) max = arr[i];
        }

        System.out.println(binarySearch(max, sum));
    }

    private static int binarySearch(int minSize, int maxSize) {
        while (minSize <= maxSize) {
            int curSize = (minSize + maxSize) / 2;

            int sum = 0;
            int cnt = 0;
            // 블루레이 개수 세기
            for (int i=0; i<N; i++) {
                // 블루레이 크기보다 용량이 크면 개수 늘리기
                if (sum + arr[i] > curSize) {
                    sum = 0;
                    cnt++;
                }
                sum += arr[i];
            }
            if (sum > 0) cnt++;

            // 개수가 더 많으면 크기가 커져야 함
            if (cnt > V) {
                minSize = curSize+1;
            } else {
                maxSize = curSize-1;
            }
        }
        return minSize;
    }
}
