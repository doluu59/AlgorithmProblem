package JAVA.Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_D3_1873_상호의배틀필드 {
    static char[][] map;
    static Tank tank;
    static int H, W;
    static final char U = '^', D = 'v', L = '<', R = '>', G = '.';
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            for (int i=0; i<H; i++) {
                String str = br.readLine();
                for (int j=0; j<W; j++) {
                    map[i][j] = str.charAt(j);
                    //탱크 초기 위치 찾으면 탱크 생성
                    switch(str.charAt(j)) {
                        case U: case D: case L: case R:
                            tank = new Tank(i, j, str.charAt(j));
                            break;
                    }
                }
            }
            //명령어 길이만큼 명령어 실행
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            for (int n=0; n<N; n++) {
                tankAction(input.charAt(n));
            }
            // output format
            sb.append("#"+tc+" ");
            for (int i=0; i<H; i++) {
                sb.append(String.copyValueOf(map[i])+"\n");
            }
        }
        // output
        bw.write(sb.toString());
        // close
        bw.flush(); bw.close(); br.close();
    }
    private static void tankAction(char act) {
        if (act != 'S') {	//명령어가 이동일 때
            //전차 방향 돌려주기
            tank.setDir(act);
            map[tank.i][tank.j] = tank.dir;
            // 방향에 맞게 이동하기
            int[] delta = setDelta(tank.dir);
            int ni = tank.i+delta[0]; int nj = tank.j+delta[1];
            if (isValid(ni, nj)) {				// 이동하는 좌표가 맵을 벗어나지 않는지
                if (map[ni][nj]==G) {			// 이동하려는 맵이 땅인지
                    map[tank.i][tank.j] = G;	//원래 탱크의 위치는 땅으로 바꾸기
                    tank.i = ni; tank.j = nj;	//탱크 새로운 위치는 이동한 자리로
                    map[tank.i][tank.j] = tank.dir;
                }
            }
        } else { 			// 명령어가 S(포탄 발사)일 때
            int[] delta = setDelta(tank.dir);
            int ni = tank.i+delta[0]; int nj= tank.j+delta[1];
            shoot:
            while (isValid(ni, nj)) {	//갱신한 좌표가 맵 밖이면 멈추기
                switch (map[ni][nj]) {	//포탄이 가려는 위치에 따라
                    case '*':
                        map[ni][nj] = G;
                        break shoot;
                    case '#':
                        break shoot;
                }
                // 포탄이 다음 방향 움직이도록 갱신
                ni += delta[0]; nj += delta[1];
            }
        }
    }
    // 전차 방향에 따라 이동하는 방향 델타
    private static int[] setDelta(char dir) {
        int[] delta = new int[2];
        switch(dir) {
            case U:
                delta[0] = -1;
                break;
            case D:
                delta[0] = 1;
                break;
            case L:
                delta[1] = -1;
                break;
            case R:
                delta[1] = 1;
                break;
        }
        return delta;
    }
    // 좌표가 맵을 벗어나는지
    private static boolean isValid(int i, int j) {
        return i>=0 && i<H && j>=0 && j<W;
    }
    // 탱크의 현재 위치와 방향을 담는 객체
    static class Tank {
        int i; int j;
        char dir;
        public Tank(int i, int j, char dir) {
            this.i = i;
            this.j = j;
            this.dir = dir;
        }
        void setDir(char dir) {
            switch(dir) {
                case 'U':
                    this.dir = U;
                    break;
                case 'D':
                    this.dir = D;
                    break;
                case 'L':
                    this.dir = L;
                    break;
                case 'R':
                    tank.dir = R;
                    break;
                case 'S':
                    break;
            }
        }
    }
}
