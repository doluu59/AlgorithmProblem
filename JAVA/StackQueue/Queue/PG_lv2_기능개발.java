package JAVA.StackQueue.Queue;

/**
 * @from Programmers
 * @index High Score Kit
 * @title 기능 개발
 * @grade Level 2
 * @classification 큐
 * @solve 작업이 끝나는 날짜를 큐에 넣는 아이디어
 */

import java.util.*;

public class PG_lv2_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ansList = new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>();

        // queue에 가장 중요한 순서의 작업부터 소요 일수를 넣음
        for (int i=0; i < progresses.length; i++) {
            queue.offerLast( (int)(Math.ceil((float)(100-progresses[i])/speeds[i])));
        }

        // 가장 앞의 업무의 배포 일자보다 적은 건 같이 나오고
        // 더 오래 걸리는 업무는 새로 카운트
        while (!queue.isEmpty()) {
            int count = 1;
            int cur = queue.pollFirst();
            // 다음 우선 순위 기능의 배포 시간이 최우선 기능보다 짧으면 같이 배포
            while (!queue.isEmpty() && cur >= queue.peekFirst()) {
                queue.pollFirst();
                count++;
            }
            // 가장 우선 순위의 기능을 배포 할 때 함께 배포하는 기능을 정답에 넣기
            ansList.add(count);
        }
        // output
        // Lit to Array
        int[] ans = new int[ansList.size()];
        for (int i=0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
