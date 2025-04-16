package JAVA.PermutationCombination.Combination;

/**
 * @from Programmers
 * @index 2025 코드챌린지 1차 예선
 * @title 비밀 코드 해독
 * @grade Level 2
 * @classification 조합
 * @solve 30이하의 숫자 중 5개를 조합하여 문제 조건에 부합하는지 비교
 */
public class PG_CodeChallenge_2025_비밀코드해독 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    static class Solution {
        public int N, M, answer;
        public boolean[] isSelected;
        public int[][] Q;
        public int[] ANS;
        public int solution(int n, int[][] q, int[] ans) {
            N = n; Q = q; ANS = ans; M = ans.length;
            answer = 0;

            isSelected = new boolean[N+1];  // 조합 만들 때 선택된 수인지
            // 조합으로 가능한 비밀 코드 조합 다 구하기 (30C5 < 15만보다 적은 수)
            comb(0, 1);
            return answer;
        }

        // 조합 구하기 (N은 최대 30, nC5)
        public void comb(int count, int index) {
            // 5개 숫자 조합 완료
            if (count == 5) {
                int[] arr = getArr();
                // 구한 숫자 조합을 암호 분석 도구에 넣어 가능한 정답인지 판별
                if (isCorrect(arr)) answer++;

                return;
            }

            if (index > N) return;

            isSelected[index] = true;
            comb(count+1, index+1);
            isSelected[index] = false;
            comb(count, index+1);
        }

        // 조합으로 고른 숫자를 배열로 반환
        public int[] getArr() {
            int[] arr = new int[5];
            int idx = 0;
            for (int i=1; i<N+1; i++) {
                if(isSelected[i]) arr[idx++] = i;
            }
            return arr;
        }

        // 조합으로 구한 정수 조합이 암호 분석 도구를 통과하는지
        public boolean isCorrect(int[] combArr) {
            // 암호 분석 도구 M번 시도
            for (int i=0; i<M; i++) {
                int correctCount = 0;
                // 이중 for문이지만 25번 연산
                for (int q : Q[i]) {
                    for (int a : combArr) {
                        // 지금 원소가 이미 비교하는 수보다 크면, 다음 원소들은 더 커서 볼 필요 없음
                        if (q < a) break;

                        if (q == a) {
                            correctCount++;
                            break;
                        }
                    }
                }
                // 한 번이라도 암호 분석 도구 통과 못하면 실패한 조합
                if (ANS[i] != correctCount) return false;
            }
            return true;
        }
    }
}
