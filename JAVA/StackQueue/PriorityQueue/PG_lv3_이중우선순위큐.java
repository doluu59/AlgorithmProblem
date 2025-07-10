package JAVA.StackQueue.PriorityQueue;

/**
 * @from Programmers
 * @index 힙
 * @title 이중 우선순위 큐
 * @grade Level 3
 * @classification Priority Queue
 * @solve 최대값, 최소값 우선순위 큐를 각각 가짐. 대신, 삭제도 해줘야 함
 */

import java.util.*;

public class PG_lv3_이중우선순위큐 {
    public static void main(String[] args) {
    }


    class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> pqMax = new PriorityQueue<>((o1, o2) -> {
                return o2-o1;
            });
            PriorityQueue<Integer> pqMin = new PriorityQueue<>();

            for (String operation : operations) {
                String[] op = operation.split(" ");
                String command = op[0];
                int num = Integer.parseInt(op[1]);

                // 삽입 명령어
                if (command.equals("I")) {
                    pqMax.offer(num);
                    pqMin.offer(num);
                    continue;
                }
                // 삭제 명령어
                if (command.equals("D")) {
                    if (pqMin.isEmpty() && pqMax.isEmpty()) continue;
                    // 최댓값 삭제
                    if (num > 0) {
                        int max = pqMax.poll();
                        pqMin.remove(max);
                    }
                    // 최솟값 삭제
                    else {
                        int min = pqMin.poll();
                        pqMax.remove(min);
                    }
                }
            }

            int[] answer = new int[2];
            answer[0] = pqMax.isEmpty() ? 0 : pqMax.poll();
            answer[1] = pqMin.isEmpty() ? 0 : pqMin.poll();
            return answer;
        }
    }
}
