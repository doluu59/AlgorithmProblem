package JAVA.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @from BOJ
 * @index 1427
 * @title 소트인사이드
 * @grade Silver 5
 * @classification 정렬
 * @solve Bubble, Selection Sort 다 사용 가능
 */

public class BOJ_s5_1427_소트인사이드 {
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArr = br.readLine().toCharArray();
        arr = new int[charArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = charArr[i] - '0';
        }

        // Bubble Sort
//        bubbleSort();
        // Selection Sort
        selectionSort();

        // output
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(String.valueOf(i));
        }
        System.out.println(sb);
    }

    // Bubble Sort
    public static void bubbleSort() {
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // selection Sort
    public static void selectionSort() {
        for (int i=0; i<arr.length; i++) {
            // find Min Value
            int maxIndex = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j=i; j<arr.length; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            // swap 1st arr item with min value
            arr[maxIndex] = arr[i];
            arr[i] = max;
        }
    }

}
