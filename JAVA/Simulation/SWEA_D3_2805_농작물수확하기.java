package JAVA.Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_D3_2805_농작물수확하기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //TC
        int TC = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=TC; tc++) {
            int profit = 0;
            //map size N
            int N = Integer.parseInt(br.readLine());

            //map input
            int[][] map = new int[N][N];
            for (int i=0; i<N; i++) {
                char[] carr = br.readLine().toCharArray();
                for (int j=0; j<N; j++) {
                    map[i][j] = carr[j]-'0';
                }
            }

            /**
             * 구현부
             * 항상 홀수 개인 마름모는 가운데를 기준으로 대칭
             * -> 가운데 (int)(N/2) 열을 기준으로 윗부분, 가운데, 아랫 부분으로 나눠서 총 합 구하기
             */
            int k=0;
            //가로로 반 잘라서 윗 부분
            for (int i=0; i<N/2; i++) {
                for (int j=N/2-k; j<=N/2+k; j++) {
                    profit += map[i][j];
                }
                k++;
            }
            //가운데
            for (int j=0; j<N; j++) {
                profit += map[N/2][j];
            }
            k=N/2-1;
            //아랫부분
            for (int i=N/2+1; i<N; i++) {
                for (int j=N/2-k; j<=N/2+k; j++) {
                    profit += map[i][j];
                }
                k--;
            }

            //output setting
            StringBuilder sb = new StringBuilder();
            sb.append("#"+tc+" "+profit+"\n");
            bw.write(sb.toString());
        }
        //close
        bw.close();
        br.close();
    }
}
