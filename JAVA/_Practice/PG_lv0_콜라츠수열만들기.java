package JAVA._Practice;

import java.util.*;

public class PG_lv0_콜라츠수열만들기 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int n) {
                List<Integer> list = new ArrayList<>();
                list.add(n);
                while(n!=1) {
                    n = n%2 == 0 ? n/2 : n*3+1;
                    list.add(n);
                }

                int[] answer = new int[list.size()];
                for(int i=0; i<list.size(); i++) {
                    answer[i] = list.get(i);
                }
                return answer;
            }
        }
    }
}
