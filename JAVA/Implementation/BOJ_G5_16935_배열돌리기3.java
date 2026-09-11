package JAVA.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_G5_16935_배열돌리기3 {
    static int N, M, R;
    static int[] r;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //input
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        //입력 배열과 연산들
        arr = new int[N][M];
        r = new int[R];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        for (int ri=0; ri<R; ri++) {
            r[ri] = Integer.parseInt(st.nextToken());
        }
        //연산 수행
        for (int ri=0; ri<R; ri++) {
            switch (r[ri]) {
                case 1:
                    compute1();
                    break;
                case 2:
                    compute2();
                    break;
                case 3:
                    compute3();
                    break;
                case 4:
                    compute4();
                    break;
                case 5:
                    compute5();
                    break;
                case 6:
                    compute6();
                    break;

            }
        }
        //output format
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                sb.append(arr[i][j]);
                if(j!=M-1) sb.append(" ");
                else sb.append("\n");
            }
        }
        //output
        bw.write(sb.toString());
        //close
        bw.flush();
        bw.close();
        br.close();
    }

    private static void compute1() {
        int[][] temp = new int[N][M];
        //한 줄의 인트는 큐로 넣어 선입 선출
        //각 줄은 스택으로 넣어서 제일 최근에 넣은 줄은 제일 먼저 꺼내어 배열에 저장
        Stack<int[]> stack = new Stack<>();
        //한 줄씩 스택에 넣기
        for (int i=0; i<N; i++) {
            stack.push(Arrays.copyOf(arr[i], M));
        }
        for (int i=0; i<N; i++) {
            temp[i] = Arrays.copyOf(stack.pop(), M);
        }

        arr = temp;
    }
    private static void compute2() {
        int[][] temp = new int[N][M];
        // 세로 줄을 스택으로 보간
        Stack<Queue> stack = new Stack<>();
        for (int j=0; j<M; j++) {
            // 세로 한 줄의 각 원소는 선입 선출인 큐
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i=0; i<N; i++) {
                queue.offer(arr[i][j]);
            }
            stack.add(queue);
        }
        //배열에 적용
        for (int j=0; j<M; j++) {
            //가장 마지막에 넣은 세로줄부터 꺼냄
            Queue<Integer> queue = stack.pop();
            for (int i=0; i<N; i++) {
                temp[i][j] = queue.poll();
            }
        }

        arr = temp;
    }
    private static void compute3() {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i=0; i<N; i++) {
            int[] row = new int[M];		//가로 한줄
            for (int j=0; j<M; j++) {
                row[j] = arr[i][j];
            }
            queue.offer(row);		//가로 한줄씩 큐에
        }
        //arr에 반영
        int[][] temp = new int[M][N];
        for (int j=N-1; j>=0; j--) {
            int[] col = queue.poll();	//큐에 넣은 순서대로 한줄씩 꺼내서
            for (int i=0; i<M; i++) {
                temp[i][j] = col[i];	//가로를 세로로 출력
            }
        }
        // newarr 리턴 어케 하지
        arr = temp;
        //N과 M 바꾸기
        int t=N; N=M; M=t;
    }
    private static void compute4() {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i=0; i<N; i++) {
            int[] row = new int[M];
            for (int j=0; j<M; j++) {
                row[j] = arr[i][j];
            }
            queue.offer(row);
        }
        int[][] temp = new int[M][N];
        //arr에 반영
        for (int j=0; j<N; j++) {
            int[] col = queue.poll();
            for (int i=M-1; i>=0; i--) {
                temp[i][j] = col[M-1-i];
            }
        }
        // newarr 리턴 어케 하지
        arr = temp;
        //N과 M 바꾸기
        int t=N; N=M; M=t;
    }
    private static void compute5() {
        //4번을 1번으로, 나머진 한칸씩 뒤로
        ArrayDeque<Queue<int[]>> blocks = makeBlocks();
        blocks.offerFirst(blocks.pollLast());
        //연산을 배열에 반영
        printBlock(blocks);
    }

    private static void compute6() {
        //1번을 4번으로
        Queue<Queue<int[]>> blocks = makeBlocks();
        blocks.offer(blocks.poll());
        //순서대로 블록에 넣으면 됨
        printBlock(blocks);

    }
    //현재 배열을 네 블록으로 나눠서 반환
    private static ArrayDeque<Queue<int[]>> makeBlocks() {
        ArrayDeque<Queue<int[]>> blocklist = new ArrayDeque<>();

        for (int b=0; b<4; b++) {
            // 0~3이 순서대로 starti, endi, startj, endj;
            int[] ij= blockIndexing(b);

            Queue<int[]> queue = new ArrayDeque<>();
            for (int i=ij[0]; i<ij[1]; i++) {
                int[] row = new int[M/2];
                int r=0;
                for (int j=ij[2]; j<ij[3]; j++) {
                    row[r] = arr[i][j];
                    r++;
                }
                queue.offer(row);
            }
            blocklist.offerLast(queue);
        }
        return blocklist;
    }
    //블록 4개 받아서 순서대로 출력
    private static void printBlock(Queue<Queue<int[]>> blocks) {
        int[][] temp = new int[N][M];
        for (int b=0; b<4; b++) {
            //하나의 블럭
            Queue<int[]> block = blocks.poll();

            //블럭 번호에 따라 배열에 들어가는 인덱스 계산
            int[] ij= blockIndexing(b);		// 0~3이 순서대로 starti, startj, endi, endj;
            for (int i=ij[0]; i<ij[1]; i++) {
                int[] row = block.poll();
                int r=0;
                for (int j=ij[2]; j<ij[3]; j++) {
                    temp[i][j] = row[r++];
                }
            }
        }
        arr = temp;
    }
    //블럭 번호에 따라 전체 큰 배열의 인덱스 계산
    private static int[] blockIndexing(int blockNum) {
        int midN = N/2;
        int midM = M/2;
        int starti, startj, endi, endj;
        starti = (blockNum==0||blockNum==1)?0:midN;
        endi = (blockNum==0||blockNum==1)?midN:N;
        startj = (blockNum==0||blockNum==3)?0:midM;
        endj = (blockNum==0||blockNum==3)?midM:M;

        return new int[] { starti, endi, startj, endj };
    }
}
