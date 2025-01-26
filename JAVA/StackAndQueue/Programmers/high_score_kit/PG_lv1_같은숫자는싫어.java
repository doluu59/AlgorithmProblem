/**
 * @from Programmers
 * @index
 * @title 같은 숫자는 싫어
 * @grade Level 1
 * @classification 스택
 */

package JAVA.StackAndQueue.Programmers.high_score_kit;

import java.util.*;

public class PG_lv1_같은숫자는싫어  {
    public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        // remove duplication
        for(int num : arr) {
            if(stack.size() == 0 || stack.getLast() != num) {
                stack.offerLast(num);
            }
        }

        // Stack to Array
        int[] answer = new int[stack.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = stack.pollFirst();
        }

        return answer;
    }
}
