package JAVA.DFSnBFS;


import java.util.*;

/**
 * @from Programmers
 * @index 알고리즘 고득점 Kit - DFS/BFS
 * @title 여행경로
 * @grade Level 3
 * @classification DFS
 * @solve 티켓 하나를 방문 체크 하기. String[] 형변환
 */
public class PG_lv3_여행경로 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        final String DEPARTURE = "ICN";
        String[][] tickets;
        boolean[] isVisited;
        int N;
        ArrayList<String> answerList;

        public String[] solution(String[][] tickets) {

            N = tickets.length;
            isVisited = new boolean[N];
            answerList = new ArrayList<>();
            this.tickets = tickets;

            dfs(0, DEPARTURE, DEPARTURE);

            // 알파벳 순으로 정렬
            Collections.sort(answerList);

            // 형변환
            String[] answer = answerList.get(0).split(" ");
            return answer;
        }

        // 사용된 항공권 수, 현재 출발지, 지금까지 온 경로
        public void dfs(int count, String cur, String path) {
            if (count == N) {
                answerList.add(path);
                return;
            }

            for (int i=0; i<N; i++) {
                if (isVisited[i]) continue;

                if (tickets[i][0].equals(cur)) {
                    isVisited[i] = true;
                    dfs(count+1, tickets[i][1], path+" "+tickets[i][1]);
                    isVisited[i] = false;
                }
            }
        }
    }
}
