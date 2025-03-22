package JAVA.Implementation;

/**
 * @from Programmers
 * @index 2023 Kakao Blind Recruitment
 * @title 개인정보 수집 유효기간
 * @grade level 1
 * @classification Implementaion
 * @solve 날짜 형식을 숫자로 바꿔서 계산하는 거 유의
 */

import java.util.*;

public class PG_KAKAO2023_lv1_개인정보수집유효기간 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public HashMap<String, Integer> termsMap;
        public int[] solution(String today, String[] terms, String[] privacies) {
            int[] answer = {};

            // 약관 별 만료일 저장
            termsMap = new HashMap<>();
            for (int i=0; i<terms.length; i++) {
                StringTokenizer st = new StringTokenizer(terms[i]);
                termsMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
            }

            // 만료된 개인정보 모으기
            List<Integer> destroyList = new ArrayList<Integer>();
            for (int i=0; i< privacies.length; i++) {
                String expiredDate = getExpiredDate(privacies[i]);  // 개인 정보 만료 날짜 구하기
                if (isExpired(expiredDate, today)) {                // 만료 됐는지
                    destroyList.add(i+1);
                }
            }

            answer = getArrayFromList(destroyList); // List to Arr
            return answer;
        }

        // 만료일 구하기
        public String getExpiredDate(String privacy) {
            StringTokenizer st = new StringTokenizer(privacy);
            String date = st.nextToken();
            String term = st.nextToken();

            int[] intDate = getIntegerDate(date);

            intDate[2]--;
            intDate[1] += termsMap.get(term);

            String expiredDate = getFormattedDate(intDate);
            return expiredDate;
        }

        // 만료 날짜가 지났는지 판단
        public boolean isExpired(String date, String today) {
            int[] intDate = getIntegerDate(date);
            int[] intToday = getIntegerDate(today);

            // year
            if (intDate[0] < intToday[0]) return true;
            if (intDate[0] > intToday[0]) return false;

            // month (year는 같음)
            if (intDate[1] < intToday[1]) return true;
            if (intDate[1] > intToday[1]) return false;

            // day
            if (intDate[2] < intToday[2]) return true;
            return false;
        }

        // string 타입 날짜 -> int
        public int[] getIntegerDate(String date) {
            int[] intDate = new int[3];
            StringTokenizer st = new StringTokenizer(date, ".");
            for (int i=0; i<3; i++) {
                intDate[i] = Integer.parseInt(st.nextToken());
            }
            return intDate;
        }

        // int 날짜 -> string
        public String getFormattedDate(int[] date) {
            // 일 변경
            if (date[2] == 0) {
                date[2] = 28;
                date[1]--;
            }

            // 12월 넘는 달은 연도 늘리기
            date[0] += date[1]/12;
            date[1] = date[1]%12;

            // 12월 예외 처리
            if (date[1] == 0) {
                date[0]--;
                date[1] = 12;
            }

            // toString
            StringBuffer sb = new StringBuffer();
            sb.append(date[0]);
            sb.append(".");
            sb.append(date[1]);
            sb.append(".");
            sb.append(date[2]);
            return sb.toString();
        }

        // List -> Array
        public int[] getArrayFromList(List<Integer> list) {
            int[] arr = new int[list.size()];
            for (int i=0; i< arr.length; i++) {
                arr[i] = list.get(i);
            }
            return arr;
        }
    }



}
