package JAVA.StackQueue.Stack;

import java.io.*;
import java.util.Stack;

/**
 * @from BOJ
 * @index 1874
 * @title 스택 수열
 * @grade Silver 2
 * @classification 스택
 * @solve 스택 구현
 */
public class BOJ_s2_1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        int num = 1;
        boolean flag = true;

        for (int i=0; i<N; i++) {
            int cur = arr[i];

            if (cur >= num) {
                while (cur >= num) {
                    stack.push(num);
                    sb.append("+\n");
                    num++;
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int popedNum = stack.pop();
                if (popedNum > cur) {
                    flag = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }

        }
        // output
        if (flag) bw.write(sb.toString());
        else bw.write("NO");
        bw.flush();
        bw.close();
    }

}
