package JAVA.PermutationCombination.Combination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author |   ysyoo
 * @platform |   SW Expert Academy
 * @index |   5215
 * @title |   햄버거 다이어트
 * @link |   문제 링크
 * @level |   D3
 * @approach |   한 줄 문제 요약
 * @algorithm |   Combination
 * @technique |   사용된 기법 (Bit masking, stream ...)
 */

public class SWEA_D3_5215_햄버거다이어트 {
    static int best, N, L;
    static Ingredient[] ing;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=TC; tc++) {
            //TC 갱신될 때마다 static 초기화
            best = Integer.MIN_VALUE;
            //input
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());	//재료 수
            L = Integer.parseInt(st.nextToken());	//칼로리 제한
            ing= new Ingredient[N];					//재료 담을 바구니
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                ing[i] = new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            //인덱스 0부터 재료 개수만큼 조합을 만들어서 칼로리와 맛을 담을 거야.
            comb(0, 0, 0);
            //output
            bw.write("#"+tc+" "+best+"\n");
        }
        //close
        bw.flush(); bw.close(); br.close();

    }
    private static void comb(int idx, int cal, int taste) {
        //모든 재료에 대한 모든 조합을 봤다면
        if (idx == N) {
            if (cal<L && taste>best) best = taste;		//칼로리가 제한보다 낮고 맛이 최고인 걸로 갱신
            return;
        }
        //이번 재료를 선택 안한 경우와 한 경우로 가지 치기
        comb(idx+1, cal, taste);									//이번재료 선택 안함
        comb(idx+1, cal+ing[idx].calorie, taste+ing[idx].taste);	//이번 재료 선택 함.
    }


    //재료 클래스
    static class Ingredient {
        int taste;
        int calorie;
        public Ingredient(int taste, int calorie) {
            this.taste = taste;
            this.calorie = calorie;
        }
    }
}
