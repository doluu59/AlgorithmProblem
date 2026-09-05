package JAVA.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_1861_정사각형방 {
    static int[][] arr;
    static int maxroom, maxcount;
    static int N;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=TC; tc++) {
            //테케 별 초기화
            maxroom =0;
            maxcount=0;
            //input
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //전체 방을 돌며 갈 수 있는 방 개수 세기
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    //dfs로 갈 수 있는 방의 개수 세기
                    int curcount = dfs(i, j, 1);
                    //기존 최대 값보다 크면 갱신
                    if (curcount > maxcount) {
                        maxcount = curcount;
                        maxroom = arr[i][j];
                    } else if (curcount == maxcount) {
                        //기존 최대값과 같으면 방의 번호가 더 작은 배열로 갱신
                        if (arr[i][j]<maxroom) {
                            maxroom = arr[i][j];
                            maxcount = curcount;
                        }
                    }
                }
            }
            //output
            bw.write("#"+tc+" "+maxroom+" "+maxcount+"\n");
        }
        //close
        bw.flush(); bw.close(); br.close();
    }
    private static int dfs(int i, int j, int count) {
        int[][] delta = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        int curroom = arr[i][j];
        //상하좌우에서 계산된 카운트 값 받아오기
        int[] curcount = new int[4];
        // 상하좌우로 이동해보기
        for (int d=0; d<4; d++) {
            //이동하려는 방의 좌표
            int nexti = i+delta[d][0];
            int nextj = j+delta[d][1];
            //배열 인덱스 유효성 검사
            if (nexti>=0&&nexti<N && nextj>=0&&nextj<N) {
                if (arr[nexti][nextj]-curroom == 1) {
                    //조건 만족하면 그 칸으로 이동, 이 dfs가 리턴 되면 현재 방향에서의 갈 수 있는 방 개수 저장됨.
                    curcount[d] = dfs(nexti, nextj, count+1);
                    continue;
                }
            }
            //못가는 방이면 현재 카운트 그대로
            curcount[d] = count;
        }
        //상 하 좌 우 중 가장 큰 값을 현재 위치에서 갈  수 있는 가장 많은 방으로 리턴
        Arrays.sort(curcount);
        return curcount[3];
    }
}
