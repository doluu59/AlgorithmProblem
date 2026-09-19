package JAVA.Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_D2_2001_파리퇴치 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            //input
            int[][] flymap = new int[N][N];
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j=0; j<N; j++) {
                    flymap[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int initSum=0;
            //0,0에서 시작한 파리채
            for (int i=0; i<M; i++) {
                for (int j=0; j<M; j++) {
                    initSum += flymap[i][j];
                }
            }
            int nextSum=0;					// x 축으로 이동하면서 갱신할 값
            int max = Integer.MIN_VALUE;	//최대값
            // 0,0 부터 M*M개 배열을 오른쪽 슬라이딩으로 N-M번하고, 끝나면 아래 슬라이딩을 한번하기 때문에
            // 왼쪽 벽에 붙은 파리채를 아래로 내리는 것을 N-M번 함 즉, i의 for문은 1+(N-M)회
            for (int i=0; i<1+N-M; i++) {
                //왼쪽 벽에 붙은 파리채를 아래로 한칸 슬라이딩 => (i가 0일 땐 초기 0,0을 가져와서 슬라이딩을 안한 상태)
                if (i!=0) {
                    for (int j=0; j<M; j++) {
                        initSum -= flymap[i-1][j];
                        initSum += flymap[i+M-1][j];
                    }
                }
                //왼쪽 벽에서 출발하는 파리채의 오른쪽 슬라이딩! 벽에 붙은 값이 최대인지 확인
                nextSum = initSum;
                if (max<nextSum) max = nextSum;
                //오른쪽으로 N-M번 슬라이딩 하면서 최대값 찾기
                for (int j=0; j<N-M; j++) {
                    for (int k=i; k<i+M; k++) {
                        nextSum -= flymap[k][j];
                        nextSum += flymap[k][j+M];
                    }
                    if (max<nextSum) max = nextSum;
                }

            }

            bw.write("#"+tc+" "+max+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
