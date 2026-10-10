package JAVA._Practice;

/**
 * [PG] 입문. 그림확대 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 문자열을 원하는 배수로 늘리기
 * - 풀이 전략   : StringBuilder로 복사
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 8.
 */

import java.lang.StringBuilder;

public class PG_lv0_입문_그림확대 {
    public static void main(String[] args) {
    }

    static class Solution {
        public String[] solution(String[] picture, int k) {
            String[] answer = new String[picture.length * k];
            int index = 0;
            for (int i = 0; i < picture.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < picture[i].length(); j++) {
                    for (int n = 0; n < k; n++) {
                        sb.append(picture[i].charAt(j));
                    }
                }   
                for (int j = 0; j < k; j++) {
                    answer[index++] = sb.toString();
                }
            }
            return answer;
        }
    }
}