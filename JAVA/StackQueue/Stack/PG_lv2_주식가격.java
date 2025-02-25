package JAVA.StackQueue.Stack;

/**
 * @from Programmers
 * @index high score kit
 * @title 주식가격
 * @grade level 2
 * @classification Stack
 * @solve 숫자가 커지는 동안 스택에 넣기. 작아지는 숫자 만나면 스택에서 빼면서 값 넣기. 끝나고 남은 스택은 끝까지 오른 주식이므로 계산
 */
import java.util.*;

public class PG_lv2_주식가격 {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        // 상승 하고 있는 시점 넣는 스택
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i=0; i<n; i++) {
            // 주식이 떨어지는 시점을 만나면 상승 시점 스택에서 제거
            while (!deque.isEmpty() && prices[deque.peekLast()]>prices[i]) {
                int lastIdx = deque.pollLast();
                answer[lastIdx] = i-lastIdx;
            }
            // 상승하면 넣기
            deque.offerLast(i);
        }

        // 주식 시간이 끝났는데 계속 오른 상태로 끝난 경우
        while (!deque.isEmpty()) {
            int lastIdx = deque.pollLast();
            answer[lastIdx] = n - 1 - lastIdx;
        }

        // 단순 반복으로 카운팅
//        for (int i=0; i<n ; i++) {
//            int cnt = 0;
//            for (int j=i+1; j<n; j++) {
//                cnt++;
//                if (prices[i] > prices[j]) break;
//            }
//            answer[i] = cnt;
//        }

        return answer;
    }
}