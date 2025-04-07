package JAVA.Implementation;
import java.util.*;
/**
 * @from Programmers
 * @index Kakao 2022 Blind Recruitment
 * @title 신고결과받기
 * @grade Level 1
 * @classification 시뮬레이션, map, set
 * @solve 맵과 셋 활용
 */
public class PG_KAKAO_2022_lv1_신고결과받기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int n = id_list.length;
            int[] answer = new int[n];
            // 이름 별로 Id 숫자 만들기
            HashMap<String, Integer> idMap = new HashMap<>();   // 유저 이름을 indexing
            for (int i=0; i<n; i++) {
                idMap.put(id_list[i], i);
            }

            // 신고 받은 횟수 저장
            int[] reportedCount = new int[n];

            // 신고 받은 사람 별로 신고 한 사람 리스트
            List<Integer>[] reportingList = new ArrayList[n];
            for (int i=0; i<n; i++) {
                reportingList[i] = new ArrayList<Integer>();
            }

            // 중복 신고는 HashSet 활용해서 제거
            HashSet<String> reportSet = new HashSet<>();
            for (String r: report) {
                reportSet.add(r);
            }

            // 신고 처리 하기
            for (String r: reportSet) {
                String[] rs = r.split(" ");
                int reportingIdx = idMap.get(rs[0]);
                int reportedIdx = idMap.get(rs[1]);

                reportedCount[reportedIdx]++;   // 신고 받은 횟수
                reportingList[reportedIdx].add(reportingIdx);   // 신고 받은 사람을 누가 신고했는지
            }

            // 정지 당한 사람을 신고한 사람에게 메일 보내기
            for (int i=0; i<n; i++) {
                if (reportedCount[i] >= k) {
                    for (Integer reportingIdx : reportingList[i]) {
                        answer[reportingIdx]++;
                    }
                }
            }
            return answer;
        }
    }
}
