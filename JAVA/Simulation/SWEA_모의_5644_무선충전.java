package JAVA.Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_모의_5644_무선충전 {
    static final int MAP_SIZE = 10;
    static final int U1=0, U2=1;
    static int M, A, sum;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=TC; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            // 사용자 1,2 입력
            User[] user = new User[2];
            user[U1] = new User(0, 0, br.readLine());
            user[U2] = new User(MAP_SIZE-1, MAP_SIZE-1, br.readLine());
            //배터리 입력
            Battery[] batteries = new Battery[A];
            for (int a=0; a<A; a++) {
                batteries[a] = new Battery(br.readLine());
            }

            sum = 0;
            // 사용자 이동
            for (int m=-1; m<M; m++) {
                //사용자 이동
                if (m>-1) {
                    // 이동
                    user[U1].move(m);
                    user[U2].move(m);
                }
                // 배터리 찾기
                // 사용자가 현 위치에서 사용할 수 있는 배터리들을 리스트에 받아오기
                List<Battery>[] blist = new ArrayList[2];
                blist[U1] = new ArrayList<>();
                blist[U2] = new ArrayList<>();
                for (int a=0; a<A; a++) {
                    //현 위치에서 a번째 배터리 사용할 수 있다면 리스트에 추가
                    if(batteries[a].canUse(user[U1].y, user[U1].x)) {
                        blist[U1].add(batteries[a]);
                    }
                    if(batteries[a].canUse(user[U2].y, user[U2].x)) {
                        blist[U2].add(batteries[a]);
                    }
                }
                // 파워가 제일 쎈 배터리가 맨 앞에 오게 정렬
                Collections.sort(blist[U1]);
                Collections.sort(blist[U2]);
                /**
                 * 배터리를 뽑을 수 있는 경우에 따라 이번 위치에서의 배터리 파워 합산
                 */
                // 둘 다 사용할 수 있는 배터리가 있을 때
                if (blist[U1].size()!=0 && blist[U2].size()!=0) {
                    //우선 가장 큰 것을 고름
                    Battery u1pick = blist[U1].get(0);
                    Battery u2pick = blist[U2].get(0);
                    //고른 게 똑같다면 (배터리 설치 위치는 다 다름)
                    if(u1pick.x==u2pick.x && u1pick.y==u2pick.y) {
                        if (blist[U1].size()==1) {
                            //사용자 1, 2 둘다 다른 선택지 없는 경우
                            if (blist[U2].size()==1) sum += u1pick.p;
                                //사용자 2는 대안 있는 경우
                            else sum += u1pick.p + blist[U2].get(1).p;
                            //사용자 1만 대안 있는 경우
                        } else if (blist[U2].size()==1) sum += blist[U1].get(1).p + u2pick.p;
                        else {	//둘 다 차선책이 있을 때 차선책이 더 큰 애로
                            int alternative = blist[U1].get(1).p > blist[U2].get(1).p ? blist[U1].get(1).p : blist[U2].get(1).p;
                            sum += u1pick.p + alternative;
                        }
                    }
                    //두 명이 고른 배터리가 다르면 둘다 선택
                    else sum += u1pick.p + u2pick.p;
                }
                // 사용할 수 있는 배터리가 없는 사용자가 있을 때 있는 애만 더해주기.
                else {
                    if (blist[U1].size()!=0) sum += blist[U1].get(0).p;
                    if (blist[U2].size()!=0) sum += blist[U2].get(0).p;
                }
            }	//주어진 시간 M만큼 이동, 배터리 사용이 끝남
            sb.append("#"+tc+" "+sum+"\n");
        }
        bw.write(sb.toString());
        bw.flush(); bw.close(); br.close();
    }
    static class Battery implements Comparable<Battery>{
        int y; int x;
        int c;
        int p;
        public Battery(String str) {
            StringTokenizer st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            this.y = y;
            this.x = x;
            this.c = c;
            this.p = p;
        }
        public boolean canUse(int ui, int uj) {		//유저 좌표 받아서 배터리 범위 안에 포함 되는지
            return Math.abs(ui-this.y)+Math.abs(uj-this.x) <= this.c;
        }
        @Override
        public int compareTo(Battery o) {	// 정렬할 때 기준이 파워 큰 거로
            return o.p-this.p;
        }
    }
    static class User {
        int y; int x;	//좌표
        int[] move;		//움직이는 방향
        public User(int y, int x, String str) {
            this.y = y;
            this.x = x;
            StringTokenizer st = new StringTokenizer(str, " ");
            move = new int[M];
            for (int i=0; i<M; i++) {
                move[i] = Integer.parseInt(st.nextToken());
            }
        }
        //움직이는 방향에 따라 움직이기
        public void move(int moveIdx) {
            switch(this.move[moveIdx]) {
                case 1:
                    this.y--;
                    break;
                case 2:
                    this.x++;
                    break;
                case 3:
                    this.y++;
                    break;
                case 4:
                    this.x--;
                    break;
                case 0:
                    break;
            }
        }
    }
}
