package JAVA.Implementation;

import java.util.*;

/**
 * @from Programmers
 * @index 2024 Kakao Winter Internship
 * @title 가장 많이 받은 선물
 * @grade Level 1
 * @classification Implementation, SI
 * @solve
 */
public class PG_KAKAO_2024_lv1_가장많이받은선물 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public HashMap<String, Integer> nameIndexMap;

        public int solution(String[] friends, String[] gifts) {
            int n = friends.length;

            // 각 사람을 숫자로 매칭하기 위함
            nameIndexMap = new HashMap<>();
            for (int i=0; i<n; i++) {
                nameIndexMap.put(friends[i], i);
            }

            // 선물 내역을 선물 Chart에 넣기
            int[][] giftChart = new int[n][n];
            for (int i=0; i<n; i++) {
                giftChart[i] = new int[n];
            }
            StringTokenizer st;

            for (String gift: gifts) {
                st = new StringTokenizer(gift);
                int from = nameToIndex(st.nextToken());
                int to = nameToIndex(st.nextToken());
                giftChart[from][to]++;
            }

            // 선물 지수 계산하기
            int[] giftPoints = new int[n];
            for (int i=0; i<n; i++) {
                int giveCount = 0;
                int receiveCount = 0;
                for (int j=0; j<n; j++) {
                    if (i != j) {
                        giveCount += giftChart[i][j];
                        receiveCount += giftChart[j][i];
                    }
                }
                giftPoints[i] = giveCount - receiveCount;
            }

            // 다음 달에 받을 선물 계산
            int[] totalGifts = new int[n];
            for (int i=0; i<n; i++) {
                for (int j=i+1; j<n; j++) {
                    // i가 준 게 더 많으면 i가 선물 받기
                    if (giftChart[i][j] > giftChart[j][i]) {
                        totalGifts[i]++;
                    }
                    // 받은 게 더 많으면 상대방이 선물 받기
                    else if (giftChart[i][j] < giftChart[j][i]) {
                        totalGifts[j]++;
                    }
                    // 같으면 선물 지수 높은 사람이 받기
                    else {
                        if (giftPoints[i] > giftPoints[j]) totalGifts[i] ++;
                        else if (giftPoints[i] < giftPoints[j]) totalGifts[j]++;
                    }
                }
            }
            // 가장 많이 선물 받는 사람의 받는 선물 수
            int answer = Integer.MIN_VALUE;
            for (int point : totalGifts ) {
                if (point > answer) answer = point;
            }

            return answer;
        }

        public int nameToIndex(String string) {
            return nameIndexMap.get(string);
        }
    }



}
