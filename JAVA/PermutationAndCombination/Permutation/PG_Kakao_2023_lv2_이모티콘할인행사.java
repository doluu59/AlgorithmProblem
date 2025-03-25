package JAVA.PermutationAndCombination.Permutation;

/**
 * @from Programmers
 * @index 2023 Kakao Blind Recruitment
 * @title 이모티콘 할인 행사
 * @grade Level 2
 * @classification Permutation
 * @solve 순열 만들어서 완전 탐색
 */
public class PG_Kakao_2023_lv2_이모티콘할인행사 {
    public static int N, M;
    public static int[] answer = new int[2];
    public static int[][] users;
    public static int[] emoticons;
    public static int[] discounts;
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {


        public int[] solution(int[][] user, int[] emoticon) {
            N = user.length;
            M = emoticon.length;

            users = user;
            emoticons = emoticon;

            discounts = new int[M];    // 각 이모티콘의 할인율
            perm (0);

            return answer;
        }

        // 이모티콘 별 할인율 순열
        public void perm(int idx) {
            // 순열 완성
            if (idx==M) {
                sellEmoticons();   // 판매 결과 얻기
                return;
            }

            // 순열 만들기
            for (int discount = 10; discount<=40; discount+=10) {
                discounts[idx] = discount;
                perm(idx+1);
            }
        }

        public void sellEmoticons() {
            int[] salesResult = new int[2];

            for (int[] user : users) {
                int purchasedPrice = 0;

                // 이모티콘 구매하기
                for (int e=0; e<M; e++) {
                    if (user[0] <= discounts[e]) {
                        purchasedPrice += (emoticons[e] - emoticons[e] * discounts[e] / 100);
                    }
                }

                // 일정 금액 이상이면 플러스 가입하기
                if (purchasedPrice >= user[1]) salesResult[0]++;
                else salesResult[1] += purchasedPrice;
            }

            // 최대값 갱신
            if (salesResult[0] > answer[0]) {
                answer[0] = salesResult[0];
                answer[1] = salesResult[1];
            } else if (salesResult[0] == answer[0]) {
                if (answer[1] < salesResult[1]) {
                    answer[1] = salesResult[1];
                }
            }
        }
    }
}
