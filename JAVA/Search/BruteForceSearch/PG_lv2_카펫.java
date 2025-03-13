package JAVA.Search.BruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @from Programmers
 * @index High Score Kit
 * @title 카펫
 * @grade Level 2
 * @classification BruteForce Search
 * @solve 직사각형의 넓이를 구해서 가능한 가로, 세로의 길이로 단순히 계산
 */
public class PG_lv2_카펫 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int brown = Integer.parseInt(br.readLine());
        int yellow = Integer.parseInt(br.readLine());
        Solution sol = new Solution();
        System.out.println(sol.solution(brown, yellow));
    }

    static class Solution {
        public int[] solution(int brown, int yellow) {
            int size = brown+yellow; // 전체 넓이
            int[] answer = new int[2];

            for (int i=1; i<=Math.sqrt(size); i++) {
                if (size%i == 0) {
                    int j = size/i; // 가로

                    int b = 2*i+2*(j-2);    // 현재 가로 세로일 떄 brown 개수
                    int y = size - b;       // yellow 개수
                    if (y==yellow && b==brown) {
                        answer[0] = j;
                        answer[1] = i;
                        break;
                    }
                }
            }
            return answer;
        }
    }



}
