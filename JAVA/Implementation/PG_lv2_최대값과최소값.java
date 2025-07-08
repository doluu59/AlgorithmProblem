package JAVA.Implementation;

/**
 * @from
 * @index
 * @title
 * @grade
 * @classification
 * @solve
 */

import java.util.*;


public class PG_lv2_최대값과최소값 {
    public static void main(String[] args) {
    }

    class Solution {
        public String solution(String s) {
            StringTokenizer st = new StringTokenizer(s);

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            while(st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                if (n < min) {
                    min = n;
                }
                if (n > max) {
                    max = n;
                }
            }
            String str = min + " " + max;
            return str;
        }
    }
}
