package JAVA._Practice;

public class PG_lv0_주사위의개수 {
    public static void main(String[] args) {
    }

    class Solution {
        public int solution(int[] box, int n) {
            return (box[0]/n) * (box[1]/n) * (box[2]/n);
        }
    }
}
