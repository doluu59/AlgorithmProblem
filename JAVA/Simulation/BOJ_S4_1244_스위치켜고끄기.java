package JAVA.Simulation;

/**
 * @author |   ysyoo
 * @platform |   Baekjoon
 * @index |   1244
 * @title |   스위치 켜고 끄기
 * @link |   https://www.acmicpc.net/problem/1244
 * @level |   Silver 4
 * @approach |   한 줄 문제 요약
 * @algorithm |   Simulatino
 * @technique |   사용된 기법 (Bit masking, stream ...)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S4_1244_스위치켜고끄기 {
    static int[] switch_;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        //스위치 개수
        int switchNum = Integer.parseInt(br.readLine());
        //switch 상태
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        switch_ = new int[switchNum];
        for (int i=0; i<switchNum; i++) {
            switch_[i] = Integer.parseInt(st.nextToken());
        }
        //학생 수
        int stdNum = Integer.parseInt(br.readLine());
        //학생 수 만큼 학생 정보 받기
        //student[남=1,여=0][받은 수]
        int[][] student = new int[stdNum][2];
        for (int i=0; i<stdNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            student[i][0] = Integer.parseInt(st.nextToken());
            student[i][1] = Integer.parseInt(st.nextToken());
        }

        // 구현부
        // 학생 별로 스위치 조작
        for (int i=0; i<stdNum; i++) {
            switch (student[i][0]) {
                //남
                //스위치 존재 범위에서 자신이 받은 수의 배수의 번호를 가진 스위치 클릭
                case 1:
                    for (int k=1; student[i][1]*k-1<switchNum; k++) {
                        click(student[i][1]*k-1);
                    }
                    break;
                //여
                //자신이 받은 수에 해당하는 스위치 먼저 누르고,
                //자신이 받은 수에 +1, -1의 번호를 가진 스위치가 서로 일치할 때까지 양 쪽 스위치 클릭
                case 2:
                    click(student[i][1]-1);
                    for (int k=1	; student[i][1]-1+k<switchNum
                            && student[i][1]-1-k>=0
                            && switch_[student[i][1]-1+k] == switch_[student[i][1]-1-k]
                            ; k++) {
                        click(student[i][1]-1+k);
                        click(student[i][1]-1-k);
                    }
                    break;
            }
        }

        //output
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<switchNum; i++) {
            sb.append(switch_[i]);
            //20번째 마다 \n, 나머지는 " "
            if ((i+1)%20==0) sb.append("\n");
            else sb.append(" ");
        }
        bw.write(sb.toString());
        //close
        bw.close();
        br.close();
    }
    //switch click method
    //인덱스 받아서 스위치 누르기
    private static void click(int i) {
        switch_[i] = switch_[i]==1? 0:1;
    }
}
