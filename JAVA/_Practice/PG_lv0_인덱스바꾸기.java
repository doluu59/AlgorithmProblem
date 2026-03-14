package JAVA._Practice;

public class PG_lv0_인덱스바꾸기 {
    public static void main(String[] args) {
        class Solution {
            public String solution(String my_string, int num1, int num2) {
                char[] arr = new char[my_string.length()];
                for (int i=0; i<my_string.length(); i++) {
                    if (i == num1) {
                        arr[num2] = my_string.charAt(i);
                        continue;
                    }
                    if (i == num2) {
                        arr[num1] = my_string.charAt(i);
                        continue;
                    }
                    arr[i] = my_string.charAt(i);
                }

                StringBuilder sb = new StringBuilder();
                for (char ch: arr) {
                    sb.append(ch);
                }
                return sb.toString();
            }
        }
    }
}
