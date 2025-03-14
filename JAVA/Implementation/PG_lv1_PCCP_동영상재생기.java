package JAVA.Implementation;
import java.util.*;
/**
 * @from Programmers
 * @index PCCP 기출문제
 * @title 동영상 재생기
 * @grade Level 1
 * @classificatin Implementation, Simulation
 * @solve "mm:ss" 형식의 String을 초 단위의 int type으로 변경하는 것이 idea
 */
public class PG_lv1_PCCP_동영상재생기 {
    public static void main(String[] args) {
    }

    static class Solution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            // 비디오 초
            int secVideoLen = strToSec(video_len);
            // 현재 분, 초
            int secPos = strToSec(pos);
            // 오프닝
            int secOpStart = strToSec(op_start);
            int secOpEnd = strToSec(op_end);

            // 오프닝 사이이면 오프닝 건너뛰기
            if (secPos >= secOpStart && secPos < secOpEnd) {
                secPos = secOpEnd;
            }
            for (int i=0; i<commands.length; i++) {
                // 명령어 받기
                secPos = commands[i].equals("next") ? secPos+10 : secPos-10;
                // 비디오 시간 범위 벗어 나는지
                if (secPos < 0) {
                    secPos = 0;
                }
                if (secPos > secVideoLen) secPos = secVideoLen;

                // 오프닝 사이이면 오프닝 건너뛰기
                if (secPos >= secOpStart && secPos < secOpEnd) {
                    secPos = secOpEnd;
                }

            }
            return secToStr(secPos);
        }

        public static int strToSec(String str) {
            int sec = 0;
            StringTokenizer st = new StringTokenizer(str, ":");
            sec += Integer.parseInt(st.nextToken())*60;
            sec += Integer.parseInt(st.nextToken());
            return sec;
        }
        public static String secToStr(int sec) {
            int min = sec/60;
            sec %= 60;

            StringBuffer sb = new StringBuffer();
            if (min < 10) sb.append("0"+min);
            else sb.append(min);
            sb.append(":");
            if (sec < 10) sb.append("0"+sec);
            else sb.append(sec);
            return sb.toString();
        }
    }
}
