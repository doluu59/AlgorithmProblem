package JAVA.TwoPointer.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @from BOJ
 * @index 1253
 * @title 좋다
 * @grade Gold 4
 * @classification 투 포인터
 * @solve 정렬 후 각 수가 좋은 수가 만들어지는 지 체크
 */
public class BOJ_g4_1253_좋다 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i =0; i<N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        int count = 0;
        Arrays.sort(numArr);
        // i = 좋은 수인지 확인 하고자 하는 수
        for (int i=0; i<N; i++) {
            int si = 0;
            int ei = N-1;
            while (si < ei) {
                // 내가 체크 하려는 숫자는 패스
                if (si == i) {
                    si++;
                    continue;
                }
                if (ei == i) {
                    ei--;
                    continue;
                }
                // 좋은 수 조건
                if (numArr[si] + numArr[ei] == numArr[i]) {
//                    System.out.println(numArr[si] + " + " + numArr[ei] + " = " + numArr[i]);
                    count++;
                    break;
                } else if (numArr[si] + numArr[ei] < numArr[i]) {
                    si++;
                } else {
                    ei--;
                }
            }
        }

        // output
        System.out.println(count);
    }
}
