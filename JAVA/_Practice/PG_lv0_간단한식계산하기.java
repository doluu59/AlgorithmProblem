package JAVA._Practice;

import java.util.*;

public class PG_lv0_간단한식계산하기 {
    public static void main(String[] args) {

        class Solution {
            public int solution(String binomial) {
                StringTokenizer st = new StringTokenizer(binomial);
                int num1 = Integer.parseInt(st.nextToken());
                String a = st.nextToken();
                int num2 = Integer.parseInt(st.nextToken());

                int answer = 0;
                switch(a) {
                    case "+" :
                        answer = num1 + num2;
                        break;
                    case "-" :
                        answer = num1 - num2;
                        break;
                    case "*" :
                        answer = num1 * num2;
                        break;
                }

                return answer;
            }
        }
    }
}
