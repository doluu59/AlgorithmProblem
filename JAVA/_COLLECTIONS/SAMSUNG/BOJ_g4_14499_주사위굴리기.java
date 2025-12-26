package JAVA._COLLECTIONS.SAMSUNG;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author      |   ysyoo
 * @platform    |   Baekjoon - 삼성 기출
 * @index       |   14499
 * @title       |   주사위 굴리기
 * @link        |   https://www.acmicpc.net/problem/14499
 * @level       |   Gold 4
 * @approach    |   주사위의 이동에 따라 면의 움직임 파악하기.
 * @algorithm   |   Simulation
 * @technique   |   2-d array
 */

public class BOJ_g4_14499_주사위굴리기 {
    public static final int[][] delta = { {0,0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public static final int EAST = 1;
    public static final int WEST = 2;
    public static final int NORTH = 4;
    public static final int SOUTH = 3;
    public static int N, M, K;
    public static int[][] map;
    public static Dice dice = new Dice();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // Y 크기
        M = Integer.parseInt(st.nextToken());   // X 크기
        map = new int[N][M];
        dice.setY(Integer.parseInt(st.nextToken()));
        dice.setX(Integer.parseInt(st.nextToken()));
        K = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        for (int k=0; k<K; k++) {
            int command = Integer.parseInt(st.nextToken());
            int output = move(command);
            if (output == -1) continue;     // 맵 벗어남
            bw.write(Integer.toString(output) + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static boolean isValid(int x, int y) {
        return x>=0 && x < M && y >= 0 && y < N;
    }

    public static int move(int command) {
        // 좌표 이동
        int ny = dice.getY() + delta[command][0];
        int nx = dice.getX() + delta[command][1];
        if (!isValid(nx, ny)) return -1;
        dice.setPos(command);
        // 주사위 굴리기
        dice.roll(command);
        // 이동한 칸이 0이면 주사위 복사, 아니면 바닥 흡수
        if (map[ny][nx] == 0) {
            map[ny][nx] = dice.getBottom();
        } else {
            dice.setBottom(map[ny][nx]); // 바닥면 흡수
            map[ny][nx] = 0;
        }

        // 상단 숫자 반환
        return dice.getTop();
    }

    public static class Dice {
        private int[] plane;    // 0이 위, 1이 바닥
        private int x, y;

        // Constructor
        public Dice() {
            this.plane = new int[6];
        }

        public void setPos(int command) {
            this.x += delta[command][1];
            this.y += delta[command][0];
        }

        public int getBottom() {
            return this.plane[1];
        }
        public void setBottom(int i) {
            this.plane[1] = i;
        }

        public int getTop() {
            return this.plane[0];
        }

        public void roll(int command) {
            switch (command) {
                case EAST:
                    this.moveEast();
                    break;
                case WEST:
                    this.moveWest();
                    break;
                case NORTH:
                    this.moveNorth();
                    break;
                case SOUTH:
                    this.moveSouth();
                    break;
            }
        }

        public void moveEast() {
            int tmp = this.plane[0];
            this.plane[0] = this.plane[4];
            this.plane[4] = this.plane[1];
            this.plane[1] = this.plane[3];
            this.plane[3] = tmp;
        }
        public void moveWest() {
            int tmp = this.plane[0];
            this.plane[0] = this.plane[3];
            this.plane[3] = this.plane[1];
            this.plane[1] = this.plane[4];
            this.plane[4] = tmp;
        }
        public void moveNorth() {
            int tmp = this.plane[0];
            this.plane[0] = this.plane[5];
            this.plane[5] = this.plane[1];
            this.plane[1] = this.plane[2];
            this.plane[2] = tmp;
        }

        public void moveSouth() {
            int tmp = this.plane[0];
            this.plane[0] = this.plane[2];
            this.plane[2] = this.plane[1];
            this.plane[1] = this.plane[5];
            this.plane[5] = tmp;
        }

        // Getter and Setter
        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
