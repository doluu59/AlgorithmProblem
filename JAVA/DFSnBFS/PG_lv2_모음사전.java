package JAVA.DFSnBFS;

/**
 * @from Programmers
 * @index 알고리즘 고득점 Kit - 완전탐색
 * @title 모음사전
 * @grade Level 2 
 * @classification DFS
 * @solve DFS로 사전 순서대로 탐색
 */
public class PG_lv2_모음사전 {
    public static void main(String[] args) {
    }

    public static class Solution {
        public int answer;
        public int count;
        public String target;

        public int solution(String word) {
            target = word;
            count = 0; answer = -1;

            dfs(new StringBuilder());
            return answer;
        }

        public void dfs (StringBuilder sb) {
            // 정답인지 비교
            if (sb.toString().equals(target)) {
                answer = count;
                return;
            }

            // 길이 5면 문자열 더 붙일 필요 X
            if (sb.length() == 5) return;

            String str = sb.toString();
            for (char c : "AEIOU".toCharArray()) {
                count++;
                dfs(sb.append(c));
                // 탐색 끝나고 오면 문자열 원래대로
                sb.setLength(0);
                sb.append(str);
            }
        }
    }

}
