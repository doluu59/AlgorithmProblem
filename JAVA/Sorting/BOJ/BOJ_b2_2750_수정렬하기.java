package JAVA.Sorting.BOJ;

/**
 * @from BOJ
 * @index 2750
 * @title 수 정렬하기
 * @grade Bronze 2
 * @classification Sorting
 */

import java.io.*;
import java.util.Arrays;

public class BOJ_b2_2750_수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);   // Java의 정렬 함수. * 어떤 정렬 알고리즘을 쓰는지, 어떤 걸 써야 하는지 파악
        for (int i=0; i<N; i++) {
            System.out.println(arr[i]);
        }
    }
}
