package JAVA.Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_D2_1954_달팽이숫자 {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());		//TC 개수
        for (int tc=1; tc<=T; tc++) {
            //input
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];		//달팽이 놀이터

            snail(0, 0, 0, 0);			//(찍은 숫자 개수, index i, index j, 달팽이가 전진할 방향)

            //output
            StringBuilder sb = new StringBuilder();
            sb.append(("#"+tc+"\n"));
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    sb.append(map[i][j]);
                    //줄의 마지막이면 개행 문자, 아니면 스페이스
                    if (j==N-1) sb.append("\n");
                    else sb.append(" ");
                }
            }
            bw.write(sb.toString());
        }
        //closing
        bw.close();
        br.close();
    }
    private static void snail(int cnt, int i, int j, int deltaIdx) {	//cnt, 이번 인덱스 i,j, 현재 방향
        int[][] delta = { {1,0}, {0,1}, {-1,0}, {0, -1}};	//달팽이가 움직일 방향, 순서대로 오른쪽, 아래, 왼쪽, 위
        if (cnt==N*N) return;		//다 움직였으면 종료

        //여기다 달팽이 현재 위치에 숫자 찍기
        map[i][j] = cnt+1;

        //새로운 인덱스 정하기.
        int ni = i + delta[deltaIdx][1];
        int nj = j + delta[deltaIdx][0];

        //새로 이동할 좌표가 맞는 좌표인지 확인
        if ( isValid(ni, nj) ) {
            //갈 수 있는 곳이면 다음 칸으로 이동
            snail (cnt+1, ni, nj, deltaIdx);
        } else {
            //갈 수 없는 칸이라서 방향을 바꿔줘야 함.
            if (deltaIdx==3) deltaIdx=0;
            else deltaIdx++;

            //바뀐 방향으로 전진
            snail(cnt+1, i + delta[deltaIdx][1], j + delta[deltaIdx][0], deltaIdx);
        }
    }

    //새로운 좌표가 달팽이 놀이터를 벗어났거나 이미 다녀온 곳이면 방향이 잘못 되었으므로 false
    private static boolean isValid( int i, int j ) {
        if (i<0 || i>=N || j<0 || j>=N || map[i][j] != 0) {
            return false;
        } else return true;
    }
}
