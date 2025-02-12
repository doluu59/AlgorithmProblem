package JAVA.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @from
 * @index
 * @title
 * @grade
 * @classification
 * @solve
 */
public class BOJ_b2_2750_수정렬하기1 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i =0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // bubble sort
        for (int i=0; i<N; i++) {
            for (int j=0; j<N-i-1; j++) {
                // swap
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // output
        for (int i=0; i<N; i++) {
            System.out.println(arr[i]);
        }
    }
}
