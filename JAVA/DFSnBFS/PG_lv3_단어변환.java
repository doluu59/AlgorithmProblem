package JAVA.DFSnBFS;

/**
 * @from Programmers
 * @index 알고리즘 고득점 Kit
 * @title 단어 변환
 * @grade Level 3
 * @classification DFS
 * @solve 사용 가능한 단어 더미에서 방문 체크하면서 최소 탐색 횟수 찾기
 */

public class PG_lv3_단어변환 {
    public static void main(String[] args) {
    }

    public static class Solution {
        public int n;
        public String target;
        public String[] words;
        public boolean[] isVisited;

        public static int min;

        public int solution(String begin, String t, String[] ws) {
            n = ws.length;
            target = t; words = ws;
            isVisited = new boolean[n];
            min = Integer.MAX_VALUE;

            dfs(0, begin);

            int answer = (min == Integer.MAX_VALUE) ? 0 : min;
            return answer;
        }

        public void dfs(int index, String str) {
            if (str.equals(target)) {
                min = index < min ? index : min;
                return;
            }

            if (index > n) return;

            //words 중에 한 글자 차이인 것들 중에 방문 안한 것만
            for (int i=0; i<n; i++) {
                if (!isPossible(str, words[i])) continue;
                if (isVisited[i]) continue;

                isVisited[i] = true;
                dfs(index+1, words[i]);
                isVisited[i] = false;
            }
        }

        public boolean isPossible(String str, String target) {
            int count = 0;
            for (int i=0; i<str.length(); i++) {
                if (str.charAt(i) != target.charAt(i)) count++;
            }

            return count == 1;
        }
    }
}
