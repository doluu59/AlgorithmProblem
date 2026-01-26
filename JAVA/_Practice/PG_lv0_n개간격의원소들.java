package JAVA._Practice;

import java.util.*;

public class PG_lv0_n개간격의원소들 {
    public static void main(String[] args) {
    }

    class Solution {
        public int[] solution(int[] num_list, int n) {
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<num_list.length; i+=n) {
                list.add(num_list[i]);
            }
            int[] answer = new int[list.size()];
            for (int i=0; i<list.size(); i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
