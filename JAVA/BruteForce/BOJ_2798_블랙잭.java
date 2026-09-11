package JAVA.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {
    static int N, M;
    static int[] cards, selects;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //input
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        cards = new int[N];
        for (int i=0; i<N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        selects= new int[3];	//조합으로 선택할 카드 3장
        //조합 N장 카드 중 3장 선택
        comb(0, 0);
        //output
        System.out.println(max);
    }
    private static void comb(int cnt, int idx) {
        if (cnt==3) {	//3장이 골라졌으면
            int sum = Arrays.stream(selects).sum();
            if (sum<=M) max = sum>max? sum : max;	//합계가 M보다 작거나 같은 수 중 가장 큰 값을 선택
            return;
        }
        if (idx==N) return;			//카드 범위를 다 봤으면 종료
        comb(cnt, idx+1);			//idx번째 카드를 고르지 않았을 떄
        selects[cnt] = cards[idx];	//idx번째 카드를 고름
        comb(cnt+1, idx+1);			//idx번째 카드를 골랐을 때
    }
}
