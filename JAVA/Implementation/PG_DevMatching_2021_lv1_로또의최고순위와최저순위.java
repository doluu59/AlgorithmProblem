import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int zeroCnt = 0;
        for (int i=0; i<6; i++) {
            if (lottos[i] == 0) zeroCnt++;
            else break;
        }
        
        // 적중 개수 계산
        int cnt = 0;
        for (int i=0; i<6; i++) {
            for (int j=zeroCnt; j<6; j++) {
                if (win_nums[i] == lottos[j]) {
                    cnt++;
                    break;
                }
            }
        }
        
        // 등수 저장
        int[] answer = { 6 - (cnt + zeroCnt) + 1, 6 - cnt + 1};
        for (int i=0; i<2; i++) {
            if (answer[i] >= 6) answer[i] = 6;
        }
        return answer;
    }
}
