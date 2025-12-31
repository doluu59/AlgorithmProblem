package JAVA._Practice;

import java.util.*;

public class PG_lv1_나누어떨어지는숫자배열 {
    public static void main(String[] args) {
    }

    class Solution {
        public int[] solution(int[] arr, int divisor) {
            List<Integer> list = new ArrayList<Integer>();

            // solve
            for (int num : arr) {
                if (num%divisor == 0) list.add(num);
            }
            if (list.size() == 0) list.add(-1);

            // List to Array
            int[] answer = new int[list.size()];
            for (int i=0; i<list.size(); i++) {
                answer[i] = list.get(i);
            }
            // sort
            Arrays.sort(answer);
            // output
            return answer;
        }
    }
}
