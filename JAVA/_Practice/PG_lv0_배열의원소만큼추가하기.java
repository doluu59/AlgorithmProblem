package JAVA._Practice;

import java.util.*;

public class PG_lv0_배열의원소만큼추가하기 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] arr) {
                List<Integer> list = new ArrayList<>();

                for (int num : arr) {
                    for (int i=0; i<num; i++) {
                        list.add(num);
                    }
                }

                int[] answer = new int[list.size()];
                for (int i=0; i<list.size(); i++) {
                    answer[i] = list.get(i);
                }
                return answer;
            }
        }
    }
}
