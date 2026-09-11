package JAVA.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_16926_배열돌리기1 {
    static int[][] delta = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, M, R;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        //input
        int[][] inputArr = new int[N][M];
        int[][] ans = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j=0; j<M; j++) {
                inputArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //	큰 사각형을 줄여 나가면서 반복
        // 	0~M까지를 1~M-1 처럼 양끝을 하나씩 줄임
        for(int borderIdx=0;borderIdx<Math.min(N, M)/(double)2; borderIdx++) {
            Queue<Integer> queue = new ArrayDeque<>();
            int i=borderIdx; int j=borderIdx; 		//테두리의 시작 인덱스
            int J=M-borderIdx;	int I=N-borderIdx;	//테두리의 끝 인덱스
            int di=0;						//delta 방향
            int qcount = 2*(I-borderIdx-1+J-borderIdx-1);		//이번 테두리의 원소 수


            /**
             * input 테두리를 큐에 넣기
             */
            queue.offer(inputArr[i][j]);	//첫 인덱스
            //테두리를 큐에 넣기
            for (int m=0; m<qcount; m++) {
                int ni = i+ delta[di][0];
                int nj = j+ delta[di][1];
                //다음 수가 경계선 넘어가는지 체크
                if (!isValidBounding(ni, nj, I, J, borderIdx)) {
                    //넘어가면 방향 바꿔주기
                    if (di!=3) di++;
                    else break;
                }
                i += delta[di][0];
                j += delta[di][1];
                if (i==borderIdx&&j==borderIdx) break;
                queue.offer(inputArr[i][j]);
            }
            /**
             * 반복 회전 빼고 실제 움직이는 만큼만 회전
             */
            for (int r=1; r<=R%qcount; r++) {
                queue.offer(queue.poll());
            }
            /**
             * 회전한 테두리를 출력 배열에 넣기
             */
            di=0;
            i=borderIdx;
            j=borderIdx;
            ans[i][j] = queue.poll();
            //돌리고 넣기 까진 됨 출력
            for (int m=0; m<qcount; m++) {
                int ni = i+ delta[di][0];
                int nj = j+ delta[di][1];
                //다음 수가 경계선 넘어가는지 체크
                if (!isValidBounding(ni, nj, I, J, borderIdx)) {
                    //넘어가면 방향 바꿔주기
                    if (di!=3) di++;
                    else break;
                }
                i += delta[di][0];
                j += delta[di][1];
                if (i==borderIdx&&j==borderIdx) break;
                ans[i][j] = queue.poll();
            }
        }
        //output
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                sb.append(ans[i][j]);
                if (j != M-1) sb.append(" ");
                else sb.append("\n");
            }
        }
        bw.write(sb.toString());
        //close
        bw.flush();
        bw.close();
        br.close();

    }
    private static boolean isValidBounding(int ni, int nj, int N, int M, int start) {
        if (ni>=N||ni<start||nj>=M||nj<start) return false;
        else return true;
    }
}