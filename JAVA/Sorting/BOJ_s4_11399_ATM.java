package JAVA.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @from BOJ
 * @index 11399
 * @title ATM
 * @grade Silver 4
 * @classification Greedy, Sorting
 * @solve Greedy 기법으로 배열을 정렬하여 작은 수로 나열
 */
public class BOJ_s4_11399_ATM {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Sorting
        // Insertion Sort
        for (int i=0; i<N; i++) {
            for (int j=i; j>0 ;j--) {
                if (arr[j] < arr[j-1]) {
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                 }
            }
        }

        // get Min
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int time = 0;
            for (int j=0; j<=i; j++) {
                time += arr[j];
            }
            sum += time;
        }

        // Output
        System.out.println(sum);
    }
}
