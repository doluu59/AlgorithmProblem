package JAVA.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @from BOJ
 * @index 9465
 * @title 스티커
 * @grade Silver 1
 * @classification DP
 * @solve 현재 좌표로 오려면 이전 단계에서 어떻게 와야 하는 지를 확인
 */
public class BOJ_s1_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            // input
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            StringTokenizer st;
            for (int s=0; s<2; s++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++) {
                    sticker[s][j] = Integer.parseInt(st.nextToken());
                }
            }

            // solve
            // idea: DP -> j >= 2 이면, 현재 스티커를 고를 경우, 선택지는 3가지
            // 1칸 앞의 대각선, 2칸 앞의 위아래 모두
            int[][] score = new int[2][n];
            for (int j=0; j<n; j++) {
                for (int i=0; i<2; i++) {
                    // j==0
                    int cur = sticker[i][j];
                    if (j==0) {
                        score[i][j] = sticker[i][j];
                        continue;
                    }

                    // j==1
                    int di = i==1 ? 0 : 1;
                    int diagonal = score[di][j-1];
                    if (j==1) {
                        score[i][j] = diagonal + cur;
                        continue;
                    }

                    // j>=2
                    int max = diagonal;
                    for (int k=0; k<2; k++) {
                        max = Math.max(max, score[k][j-2]);
                    }
                    score[i][j] = max + cur;
                }
            }

            //output
            int output = Math.max(score[0][n-1], score[1][n-1]);
            System.out.println(output);
        }
    }

    // 재귀
    /*
    public static int getScore(int i, int j) {
        int cur = sticker[i][j];
        if (j==0) return cur;

        int di = i==1 ? 0 : 1;
        int diagonal = getScore(di, j-1);
        if(j==1) return diagonal + cur;

        // idea
        // DP -> 현재 스티커를 골랐을 경우, 이 전은 대각선 꺼 아니면 두칸 앞
        // j >= 2 이면, 현재 스티커를 고를 경우, 선택지는 3가지
        // 대각선의 이전 스티커, 2칸 앞의 스티커 위아래 모두
        int max = diagonal;

        for (int k=0; k<2; k++) {
            max = Math.max(max, getScore(k, j-2));
        }

        return max + cur;
    }
    */
}
