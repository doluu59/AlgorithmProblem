package JAVA.Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_모의_1953_탈주범검거 {
    static int N, M;
    static int[][] map;
    static boolean[][] isCounted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=TC; tc++) {
            int ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());	//세로
            M = Integer.parseInt(st.nextToken());	//가로
            int R = Integer.parseInt(st.nextToken());	//맨홀 좌표
            int C = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());	//시간

            map = new int[N][M];
            isCounted = new boolean[N][M];
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<Pos> queue = new ArrayDeque<>();
            queue.offer(new Pos(R, C));
            isCounted[R][C] = true;
            ans=1;
            for (int l=1; l<L; l++) {	//시간 반복
                //이번 시간에 갈 수 있는 만큼만 꺼내야 해
                int nowQsize = queue.size();
                for (int i=0; i<nowQsize; i++) {	//이번 시간에 있는 경우의 수
                    //이번 시간에 있는 경우의 수에서 발생할 수 있는 새로운 경로
                    for (Pos pos: getMove(queue.poll())) {
                        queue.offer(pos);
                        ans++;
                        isCounted[pos.r][pos.c] = true;
                        System.out.println("l: "+l+" "+pos.r+" "+pos.c);
                    }
                    //이번 턴에 꺼낼 수 있는 개수 만큼 꺼냈으니 다음 턴엔
                }
            }

            //output 한 줄 추가
            sb.append("#"+tc+" "+ans+"\n");
        }
        //output 한 번에 쓰기
        bw.write(sb.toString());
        //close
        bw.flush(); bw.close(); br.close();
    }
    //현재 터널 모양에 따라 다음에 갈 수 있는 곳을 추가 해줌
    static List<Pos> getMove(Pos now) {
        int[][] delta = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };	//상하좌우
        List<Pos> list = new ArrayList<>();
        //내가 온자리는 또 안더해줘야 함;;;
        switch (map[now.r][now.c]) {
            case 1:
                for (int i=0; i<4; i++) {
                    int nr = now.r+delta[i][0];
                    int nc = now.c+delta[i][1];
                    if(isTunnel(nr, nc, i)) list.add(new Pos(nr, nc));
                }
                break;
            case 2:
                for (int i=0; i<2; i++) {
                    int nr = now.r+delta[i][0];
                    int nc = now.c+delta[i][1];
                    if(isTunnel(nr, nc, i)) list.add(new Pos(nr, nc));
                }
                break;
            case 3:
                for (int i=2; i<4; i++) {
                    int nr = now.r+delta[i][0];
                    int nc = now.c+delta[i][1];
                    if(isTunnel(nr, nc, i)) list.add(new Pos(nr, nc));
                }
                break;
            case 4:
                for (int i=0; i<4; i+=3) {
                    int nr = now.r+delta[i][0];
                    int nc = now.c+delta[i][1];
                    if(isTunnel(nr, nc, i)) list.add(new Pos(nr, nc));
                }
                break;
            case 5:
                for (int i=1; i<4; i+=2) {
                    int nr = now.r+delta[i][0];
                    int nc = now.c+delta[i][1];
                    if(isTunnel(nr, nc, i)) list.add(new Pos(nr, nc));
                }
                break;
            case 6:
                for (int i=1; i<4; i++) {
                    int nr = now.r+delta[i][0];
                    int nc = now.c+delta[i][1];
                    if(isTunnel(nr, nc, i)) list.add(new Pos(nr, nc));
                }
                break;
            case 7:
                for (int i=0; i<=2; i+=2) {
                    int nr = now.r+delta[i][0];
                    int nc = now.c+delta[i][1];
                    if(isTunnel(nr, nc, i)) list.add(new Pos(nr, nc));
                }
                break;
        }
        return list;
    }
    static boolean isTunnel(int r, int c, int di) {
        if (r<0||r>=N||c<0||c>=M) return false;		//맵 벗어나면 false
        if (isCounted[r][c]) return false;			//이미 포함된 거면 false
        if (map[r][c] != 0) {
            if (isValidTunnel(map[r][c], di)) {
                return true;
            }
        }
        return false;
    }
    //연결 방향이 올바른 터널인가?
    private static boolean isValidTunnel(int TunnelType, int di) {
        boolean isCorrect = false;
        switch (di) {
            case 0:	//움직이는 이동 방향이 상
                switch (TunnelType) {
                    case 1: case 2: case 5: case 6:
                        isCorrect = true;
                        break;
                }
                break;
            case 1:	//하
                switch (TunnelType) {
                    case 1: case 2: case 4: case 7:
                        isCorrect = true;
                        break;
                }
                break;
            case 2:
                switch (TunnelType) {
                    case 1: case 3: case 4: case 5:
                        isCorrect = true;
                        break;
                }
                break;
            case 3:
                switch (TunnelType) {
                    case 1: case 3: case 6: case 7:
                        isCorrect = true;
                        break;
                }
                break;
        }
        return isCorrect;
    }

    static class Pos {
        int r; int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}