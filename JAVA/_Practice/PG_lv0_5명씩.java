package JAVA._Practice;

import java.util.*;

public class PG_lv0_5명씩 {
    public static void main(String[] args) {
        class Solution {
            public String[] solution(String[] names) {
                List<String> list = new ArrayList<>();
                for (int i=0; i<names.length; i++) {
                    if (i%5 == 0) list.add(names[i]);
                }
                String[] answer = new String[list.size()];
                for(int i=0; i<list.size(); i++) {
                    answer[i] = list.get(i);
                }
                return answer;
            }
        }
    }
}
