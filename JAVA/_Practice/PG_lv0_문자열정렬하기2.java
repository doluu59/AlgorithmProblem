package JAVA._Practice;

import java.util.*;

public class PG_lv0_문자열정렬하기2 {
    public static void main(String[] args) {

        class Solution {
            public String solution(String my_string) {
                my_string = my_string.toLowerCase();
                char[] arr = my_string.toCharArray();
                Arrays.sort(arr);
                return String.valueOf(arr);
            }
        }
    }
}
