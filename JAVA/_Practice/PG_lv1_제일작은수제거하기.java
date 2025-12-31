package JAVA._Practice;

import java.util.*;

public class PG_lv1_제일작은수제거하기 {
    public static void main(String[] args) {
    }

    class Solution {
        public int[] solution(int[] arr) {
            // get Min
            int min = Integer.MAX_VALUE;
            for (int num : arr) {
                if (num < min) min = num;
            }

            // Eliminate Min
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<arr.length; i++) {
                if (arr[i] != min) list.add(arr[i]);
            }

            if (list.isEmpty()) list.add(-1);

            // List to Array
            int[] answer = new int[list.size()];
            for (int i=0; i<list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}
