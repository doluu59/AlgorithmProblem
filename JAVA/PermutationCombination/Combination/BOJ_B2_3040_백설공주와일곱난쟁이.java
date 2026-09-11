package JAVA.PermutationCombination.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B2_3040_백설공주와일곱난쟁이 {
    static int[] dwarfs;	//9마리의 난쟁이
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;			//9마리 난쟁이의 숫자 합
        dwarfs = new int[9];
        short flag = 0;					//가짜 난쟁이를 체크할 플래그
        for (int i=0; i<9; i++) {		//난쟁이 입력 받으면서 9마리 전체 합 구하기
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum+=dwarfs[i];
        }
        combi(0, 0, sum, flag);			//전체 9마리의 합과 아무도 고르지 않은 플래그를 주어 조합 시작
    }
    //9마리 난쟁이 중에 2마리를 골라서 걔네가 가짜라고 선택 => 그 때 합이 100이면 진짜 걔네가 가짜
    private static void combi(int cnt, int idx, int sum, short flag) {
        if(cnt==2) {
            if (sum==100) {		//가짜 두마리 골랐는데 합이 100 => 가짜 제대로 골랐으니 출력
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<9; i++) {
                    if ((flag & 1<<i) == 0) sb.append(dwarfs[i]+"\n");
                }
                System.out.println(sb.toString());
            }
            return;
        }
        //조합을 현재 인덱스 난쟁이를 가짜라고 고르지 않은 경우, 고른 경우로 가지쳐서 전체 난쟁이까지 탐색
        if (idx==9) return;
        combi(cnt, idx+1, sum, flag);
        combi(cnt+1, idx+1, sum-dwarfs[idx], (short) (flag | (1<<idx)));
    }
}
