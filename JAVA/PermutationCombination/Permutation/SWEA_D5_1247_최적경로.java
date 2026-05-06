package JAVA.PermutationCombination.Permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_D5_1247_최적경로 {
    static int N;				// 방문 해야 하는 고객 수
    static int[] order;			// 방문 순서
    static Pos company ,home;	// 회사와 집 좌표
    static Pos[] client;		// 방문 해야 하는 집 좌표
    static int min;				// 방문 가능한 거리 중 최소 거ㅣㄹ
    static int flag;			// 방문 순서를 만들 순열에서 선택된 친구인지 flag
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=TC; tc++) {
            //TC 별 변수 초기화
            N = Integer.parseInt(br.readLine());
            order = new int[N];
            //company, home, client 좌표 input
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            company = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            client = new Pos[N];
            for (int i=0; i<N; i++) {
                client[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            min = Integer.MAX_VALUE;
            flag = 0;
            perm(0);	//순열 사용하여 방문 순서 가능한 조합 모두 만들기
            // output format
            sb.append("#"+tc+" "+min+"\n");
        }
        //output
        bw.write(sb.toString());
        //close
        bw.flush(); bw.close(); br.close();
    }
    private static void perm(int cnt) {
        // 종료 조건
        if (cnt == N) {
            int dist=0;									//이번에 만든 방문 순서대로 방문 할 때의 이동 거리
            dist += getDist(company, client[order[0]]);	//회사에서 처음 방문할 집
            for (int i=0; i<N; i++) {
                //마지막 고객 좌표는 집과의 거리, 나머지 고객 집은 다음 고객 집까지의 거리
                dist += (i!=N-1) ? getDist(client[order[i]], client[order[i+1]]) : getDist(client[order[i]], home);
            }
            // 순열로 만든 방문 순서 중 최단 거리 갱신
            if (dist<min) min = dist;
            return;
        }
        //순열
        for (int i=0; i<N; i++) {
            // i번째가 앞에서 포함 되었으면 다음 애로
            if ((flag & 1<<i) != 0) continue;
            // i번째를 이번 원소로
            flag |= 1<<i;
            order[cnt] = i;
            // i를 넣은 뒤 뒤의 배열 채우기 위한 재귀
            perm(cnt+1);
            flag &= ~(1<<i);
        }

    }
    //p1과 p2 간의 거리 반환
    private static int getDist(Pos p1, Pos p2) {
        return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
    }
    //좌표 클래스
    static class Pos {
        int y; int x;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
