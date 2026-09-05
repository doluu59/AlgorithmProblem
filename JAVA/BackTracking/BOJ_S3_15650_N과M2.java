package JAVA.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_15650_N과M2 {
    static int[] nums; 	//수열 저장
    static int N, M;	//nCr에서 n=N, r=M
    public static void main(String[] args) throws IOException {
        //read, write 도구
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //input
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];

        //조합
        comb(0, 0);
    }
    private static void comb(int cnt, int idx) {
        if (cnt==M) {
            //output formating
            StringBuilder sb = new StringBuilder();
            //수열의 길이만큼 문자열 포맷팅
            for (int i=0; i<nums.length; i++) {
                sb.append(nums[i]);
                //수열의 마지막 숫자 끝에는 공백 안주기 위해서
                if (i!=nums.length-1) sb.append(" ");
            }
            //output print
            System.out.println(sb.toString());
            return;
        }

        /**
         * Combination
         * 현재 index부터만 탐색 => index보다 작은 수는 넣을 수 없음.
         */
        for (int i=idx; i<N; i++) {
            nums[cnt] = i+1;
            comb(cnt+1, i+1);
        }
    }
}
