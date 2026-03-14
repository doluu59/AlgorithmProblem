package JAVA._Practice;

public class PG_lv0_배열비교하기 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] arr1, int[] arr2) {
                int answer = 0;
                // #1
                answer = arr1.length < arr2.length ? -1 : 1;
                if (arr1.length != arr2.length) return answer;

                // #2
                int[] sum = new int[2];
                for (int i=0; i<arr1.length; i++) {
                    sum[0] += arr1[i];
                    sum[1] += arr2[i];
                }
                answer = sum[0] < sum[1] ? -1 : 1;
                if (sum[0] == sum[1]) answer = 0;
                return answer;
            }
        }
    }
}
