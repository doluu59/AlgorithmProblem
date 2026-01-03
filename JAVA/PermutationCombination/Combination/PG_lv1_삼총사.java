package JAVA.PermutationCombination.Combination;

public class PG_lv1_삼총사 {
    public static void main(String[] args) {
    }

    class Solution {
        boolean[] isVisited;
        int[] number;
        int len;
        int answer = 0;
        public int solution(int[] num) {
            number = num;
            len = number.length;
            isVisited = new boolean[len];
            comb(0, 0);
            return answer;
        }

        public void comb(int idx, int cnt) {
            if (cnt == 3) {
                if (sum()==0) answer++;
                return;
            }

            if (idx == len) return;

            isVisited[idx] = true;
            comb(idx+1, cnt+1);
            isVisited[idx] = false;
            comb(idx+1, cnt);
        }

        public int sum() {
            int sum = 0;
            for (int i=0; i<len; i++) {
                if (isVisited[i]) sum+= number[i];
            }
            return sum;
        }
    }
}
