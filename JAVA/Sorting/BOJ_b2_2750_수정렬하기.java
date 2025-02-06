package JAVA.Sorting;

/**
 * @from BOJ
 * @index 2750
 * @title 수 정렬하기
 * @grade Bronze 2
 * @classification Sorting
 * @explanation : BubbleSort. N이 1000이하의 자연수이므로 O(N^2)의 시간복잡도를 가져도 충분
 */

import java.io.*;
import java.util.Arrays;

public class BOJ_b2_2750_수정렬하기 {
    public static int[] arr;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

//        Arrays.sort(arr);   // Java의 정렬 함수. * 어떤 정렬 알고리즘을 쓰는지, 어떤 걸 써야 하는지 파악
        bubbleSort(arr);

        for (int i=0; i<N; i++) {
            System.out.println(arr[i]);
        }
    }

    // 버블 정렬 (완전 단순 정렬)
    // 배열의 첫번째 원소 부터 다음 원소와 크기를 비교 하여 제일 큰 값의 원소를 배열의 가장 끝으로 정렬
    public static void bubbleSort(int[] arr) {
        for (int i=0; i<N-1; i++) {         //
            for (int j=0; j<N-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
