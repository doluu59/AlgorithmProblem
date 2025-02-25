package JAVA.StackQueue.Queue;

/**
 * @from Programmers
 * @index high score kit
 * @title 프로세스
 * @grade lv2
 * @classification Queue
 * @solve 단순 Queue 구현
 */

import java.util.*;

public class PG_lv2_프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        // input
        Queue<Item> queue = new LinkedList<>();
        for (int i=0; i<priorities.length; i++) {
            queue.offer(new Item(priorities[i], i));
        }
        // 프로세스 실행하기
        while (!queue.isEmpty()) {
            Item curItem = queue.poll();
            boolean isPriority = true;

            // 가장 높은 우선 순위 찾기
            for (int i=0; i<queue.size(); i++) {
                Item nextItem = queue.poll();
                if (curItem.priority < nextItem.priority) {
                    isPriority = false;
                }
                queue.offer(nextItem);
            }
            // 2. 더 우선순위인 프로세스 있으면 맨 뒤로
            if (!isPriority) {
                queue.offer(curItem);
                continue;
            }
            // 3. 가장 우선 순위라면 찾고자 하는 프로세스인지 체크
            if (curItem.index == location) {
                break;
            }
            // 찾는 게 아니라면 현재 프로세스 종료
            answer++;
        }
        // output
        return answer;
    }

    public static class Item {
        int priority;
        int index;

        public Item(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }
}