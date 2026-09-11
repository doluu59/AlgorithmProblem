package JAVA.PermutationCombination.Combination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_D3_9229_한빈이와SpotMart {
    static int[] arr;
    static int N, M;
    static int sum;
    static int max;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        //TC
        for (int tc=1;tc<=TC; tc++) {
            max=-1;		// 정답이 될 최댓값
            sum=0;		// 고른 두 봉지의 무게의 합

            //input
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            arr = new int[N];
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            //arr 원소 중 2개 고르는 조합
            comb(0, 0);
            //output
            bw.write("#"+tc+" "+max+"\n");
        }
        //close
        bw.flush();
        bw.close();
        br.close();
    }
    //
    private static void comb(int cnt, int idx) {
        if(cnt==2) {
            if(sum<=M) {
                if (sum>max) max = sum;
            }
            return;
        }
        if(idx==N) return;
        //이번 index의 과자를 고른 경우
        sum+=arr[idx];
        comb(cnt+1, idx+1);
        //안 고른 경우
        sum-=arr[idx];
        comb(cnt, idx+1);
    }
}
