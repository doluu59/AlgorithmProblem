/**
 * @from Programmers
 * @index
 * @title 모의고사
 * @grade Level 1
 * @classification 완전 탐색
 */

package JAVA.BruteForceSearch.Programmers.high_score_kit;

import java.util.*;

public class PG_lv1_모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int a=0;
        int b=0;
        int c = 0;
        for (int i = 0; i<answers.length; i++) {
            if (answers[i] == ((i%5)+1)) a++;

            if (i%2 == 1) {
                switch (((i+1)/2)%4) {
                    case 1:
                        if (1 == answers[i]) b++;
                        break;
                    case 2:
                        if (3 == answers[i]) b++;
                        break;
                    case 3:
                        if (4 == answers[i]) b++;
                        break;
                    case 0:
                        if (5 == answers[i]) b++;
                        break;
                }
            } else {    //홀수번째
                if (answers[i] == 2) b++;
            }
            switch (i%10) {
                case 0: case 1 :
                    if ( answers[i] == 3) c++;
                    break;
                case 2: case 3 :
                    if ( answers[i] == 1) c++;
                    break;
                case 4: case 5 :
                    if ( answers[i] == 2) c++;
                    break;
                case 6: case 7 :
                    if ( answers[i] == 4) c++;
                    break;
                case 8: case 9 :
                    if ( answers[i] == 5) c++;
                    break;
            }
        }
        int max = Integer.MIN_VALUE;
        if (a > max) max = a;
        if (b > max) max = b;
        if (c > max) max = c;

        List<Integer> ans = new ArrayList<>();
        if (max == a) ans.add(1);
        if (max == b) ans.add(2);
        if (max == c) ans.add(3);

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}