package JAVA.Search.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author          |   ysyoo
 * @platform        |   Baekjoon
 * @index           |   12015
 * @title           |   가장 긴 증가하는 부분 수열
 * @link            |   https://www.acmicpc.net/problem/12015
 * @level           |   Gold 2
 * @approach        |   LIS (최장 증가 수열 구하기) -> 시간 복잡도로 인해, 이분 탐색 활용
 * @algorithm       |   Binary Search
 * @technique       |
 * @last_modified   |   2025-10-31 오후 7:55
 */

public class BOJ_g2_12015_가장긴증가하는부분수열2 {
    public static int[] arr;
    public static List<Integer> lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        // LIS 구하기
        lis = new ArrayList<>();
        lis.add(arr[0]);
        for (int i=1; i<n; i++) {
            getLIS(i);
        }

        // output
        int answer = lis.size();
        System.out.println(answer);
    }

    private static int getLIS(int i) {
        // 현재 LIS의 가장 큰 숫자보다 큰 숫자면 LIS에 추가
        if (arr[i] > lis.get(lis.size()-1)) {
            lis.add(arr[i]);
//            System.out.println(" LIS RESULT ");
//            System.out.println(lis.toString());
            return lis.size();
        }

        // LIS의 최고 숫자보다 작다면, 이분 탐색 해서 자리 찾기
        int left = 0;
        int right = lis.size()-1;
        lis.set(binarySearch(left, right, arr[i]), arr[i]);

//        System.out.println(" LIS RESULT after binary search");
//        System.out.println(lis.toString());
        return lis.size();
    }

    private static int binarySearch(int left, int right, int target) {
        // Binary Search : O(logN)
        // 바꿔줄 지점 찾기
        int mid = (left + right) / 2;

        while(left<right) {
            // 바꿀 지점 찾았음
            if (lis.get(mid) == target) {
                return mid;
            }

            if (target < lis.get(mid)) {
                right = mid;
            } else {
                left = mid+1;
            }

            mid = (left + right) / 2;
        }

//        System.out.printf("Binary Search result : left = %d, right = %d, mid index = %d\n", left, right, mid);
        return mid;
    }
}
