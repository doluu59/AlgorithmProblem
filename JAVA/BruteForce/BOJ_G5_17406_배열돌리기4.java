package JAVA.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_17406_배열돌리기4 {
    static int N, M, K;
    static int[][] arr;
    static Rotate[] rotates;
    static int min = Integer.MAX_VALUE;
    static int flag;
    static int[] order;
    static int[][] output;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());	//배열 크기
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());	//연산 개수

        //배열 입력 받기
        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //회전 연산 받기
        rotates = new Rotate[K];
        for (int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            rotates[k] = new Rotate(Integer.parseInt(st.nextToken())-1,
                    Integer.parseInt(st.nextToken())-1,
                    Integer.parseInt(st.nextToken()) );
        }

        order = new int[K];
        flag = 0;
        //회전 연산 kPk 순열 돌려서
        perm(0, flag);
        //회전 한 후 최소 값 구하기

        bw.write(Integer.toString(min));
        //close
        bw.flush(); bw.close(); br.close();
    }
    private static void perm(int cnt, int flag) {
        if (cnt == K) {							//순열 완성
            output = new int[N][M];				//순열 하나당 결과 하나 나오니까 이 때 출력 배열 초기화
            for (int n=0; n<N; n++) {			//입력 배열 복사
                output[n] = arr[n].clone();
            }
            //순열에서 골라진 순서대로 회전 연산 수행
            for (int i=0; i<K; i++) {
                rotate(rotates[order[i]].r,
                        rotates[order[i]].c,
                        rotates[order[i]].s
                );
            }
            //회전이 다 끝난 뒤.
            //각 행 별로 합을 구해서 그 중 최소값
            int curmin = Integer.MAX_VALUE;
            for (int i=0; i<N; i++) {
                int rsum =  Arrays.stream(output[i]).sum();
                curmin = rsum<curmin?rsum:curmin;
            }
            min = curmin<min?curmin:min;		//최소값 갱신
        }
        //순열
        for (int i=0; i<K; i++) {
            if ((flag&1<<i) != 0) continue;		//i가 선택되었다면 뺴기
            order[cnt] = i;
            perm(cnt+1, flag | 1<<i);			//이번꺼 체크하고 다음 인덱스로 출발~
        }
    }
    //회전 연산 한번
    private static void rotate(int r, int c, int s) {
        int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        //테두리 개수만큼 회전
        for (int k=s; k>0; k--) {
            Pos start = new Pos(c-k, r-k);
            Pos end = new Pos(c+k, r+k);
            //큐에 테두리 담기
            Queue<Integer> queue = new ArrayDeque<>();
            int qcount = 4*( 2*k+1 -1 );	//(한 변의 길이 -1) *4
            queue.offer(output[start.y][start.x]);
            int i = start.y; int j = start.x; int di=0;
            for (int n=0; n<qcount; n++) {
                int ni = i+ delta[di][0];
                int nj = j+ delta[di][1];
                //벽에 부딪히면 방향 바꿔주기
                if (!isValid(ni, nj, start, end)) {
                    if (di!=3) di++;
                }
                //큐에 테두리 값 넣기
                i += delta[di][0];
                j += delta[di][1];
                if (i==start.y && j==start.x) break;
                queue.offer(output[i][j]);
            }
            //맨 앞에꺼 하나 맨 뒤 -> 회전 효과
            queue.offer(queue.poll());
            //회전한 결과를 출력 배열에 넣기
            di = 0;
            output[i][j] = queue.poll();	//시작점에서 멈췄을 거야
            //이제 회전한 결과물을 넣을 차례
            for (int n=0; n<qcount; n++) {
                int ni = i+ delta[di][0];
                int nj = j+ delta[di][1];
                //다음 수가 경계선 넘어가는지 체크
                if (!isValid(ni, nj, start, end)) {
                    if (di!=3) di++;
                }
                i += delta[di][0];
                j += delta[di][1];
                if (i==start.y && j==start.x) break;
                output[i][j] = queue.poll();
            }

        }
    }
    //맵을 벗어나는지 체크
    private static boolean isValid(int ni, int nj, Pos start, Pos end) {
        return (ni>=start.y && ni<=end.y && nj>=start.x && nj<=end.x );
    }

}
class Rotate {
    int r;
    int c;
    int s;
    public Rotate(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}
class Pos {
    int x; int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
