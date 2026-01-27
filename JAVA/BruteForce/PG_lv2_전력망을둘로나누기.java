package JAVA.BruteForce;

/**
 * @author |   ysyoo
 * @platform |   Programmers
 * @index |   알고리즘 고득점 Kit - 완전 탐색
 * @title |   전력망을 둘로 나누기
 * @link |   https://school.programmers.co.kr/learn/courses/30/lessons/86971
 * @level |   Level 2
 * @approach |   양방향 그래프에서 엣지 하나 제거 후, 연결된 노드 개수 비교
 * @algorithm |   Brute Force (BFS)
 * @technique |   BFS, Queue
 */
import java.util.*;

public class PG_lv2_전력망을둘로나누기 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean[][] map;
        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;

            map = new boolean[n+1][n+1];
            for (int i=0; i<wires.length; i++) {
                map[wires[i][0]][wires[i][1]] = true;
                map[wires[i][1]][wires[i][0]] = true;
            }

            // 엣지 중 하나를 뺐을 때
            for (int[] wire : wires) {
                // 임의의 전선 끊기
                map[wire[0]][wire[1]] = false;
                map[wire[1]][wire[0]] = false;

                // 아무 노드나 선택 해서 BFS => 연결된 노드 개수
                int grid = bfs(n);

                // 두 그룹 간 차이 절댓값 최소 찾기
                answer = Math.min(answer, Math.abs(grid - (n-grid)));

                // 전선 되돌리기
                map[wire[0]][wire[1]] = true;
                map[wire[1]][wire[0]] = true;
            }
            return answer;
        }

        public int bfs(int n) {
            boolean[] isVisited = new boolean[n+1];
            Queue<Integer> queue = new ArrayDeque<>();

            int startNode = 1;
            queue.offer(startNode);

            while (!queue.isEmpty()) {
                int curNode = queue.poll();
                if (isVisited[curNode]) continue;
                isVisited[curNode] = true;
                for (int i=1; i<=n; i++) {
                    if (curNode==i || !map[curNode][i]) continue;   // 연결된 노드만 남기기
                    if (isVisited[i]) continue;                     // 이미 방문한 Node Pass
                    queue.offer(i);
                }
            }
            int count = 0;      // 전력망에 연결된 송전탑 개수
            for (boolean visitedNode : isVisited) {
                if (visitedNode) count++;
            }

            return count;
        }
    }
}
