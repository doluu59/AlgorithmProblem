package JAVA.StackQueue.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @from BOJ
 * @index 17298
 * @title 오큰수
 * @grade Gold 4
 * @classification 스택
 * @solve
 */
public class BOJ_g4_17298_오큰수 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] ans = new int[N];

        // solve
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<N; i++) {

            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int topIndex = stack.pop();
                ans[topIndex] = arr[i];
            }
            stack.push(i);
        }

        // -1
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        // output
        for (int i=0; i<N; i++) {
            sb.append(ans[i]+" ");
        }
        System.out.println(sb.toString());
    }
}
