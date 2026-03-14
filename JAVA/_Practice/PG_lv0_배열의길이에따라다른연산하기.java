package JAVA._Practice;

public class PG_lv0_배열의길이에따라다른연산하기 {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(int[] arr, int n) {
                int[] answer = new int[arr.length];
                for (int i=0; i<arr.length; i++) {
                    if (arr.length%2 != 0) answer[i] = i%2==0 ? arr[i] + n : arr[i];
                    else answer[i] = i%2==0 ? arr[i] : arr[i] + n;
                }
                return answer;
            }
        }
    }
}
