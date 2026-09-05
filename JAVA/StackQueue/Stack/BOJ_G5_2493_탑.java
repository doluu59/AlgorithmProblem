package JAVA.StackQueue.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_G5_2493_탑 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        //input
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //input - stack
        Deque<int []> stack = new ArrayDeque<>();
        for (int idx=0; idx<N; idx++) {
            int laser = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                //날 받을 이전의 탑이 없음 -> 0 출력
                sb.append(0+" ");
                stack.offerLast(new int[]{idx+1, laser});
                continue;
            }
            //비어있지 않으면 나보다 더 큰애 찾기
            while (!stack.isEmpty())  {
                if( laser > stack.peekLast()[1] ) stack.pollLast();	//이전보다 내가 더 크면 그냥 꺼내서 버리기
                else {
                    sb.append(stack.peekLast()[0]);
                    break;
                }
            }

            if (stack.isEmpty()) {
                //날 받을 이전의 탑이 없음 -> 0 출력
                sb.append(0);

            }
            stack.offerLast(new int[]{idx+1, laser});
            //output format
            if (idx!=N) sb.append(" ");
            else sb.append("\n");
        }
        //output
        System.out.println(sb.toString());
    }
}
