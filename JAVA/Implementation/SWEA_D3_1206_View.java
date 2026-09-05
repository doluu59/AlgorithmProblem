package JAVA.Implementation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * [SWEA] 1206. View (D3)
 * @category Implementation
 *
 * @implNote
 * - 문제 요약   : 각 건물에서 양옆 2칸 이내의 건물들보다 높을 때 확보되는 조망권 세대의 총합 구하기
 * - 풀이 전략   : 1차원 배열을 순회하며 각 인덱스에서 인접한 4개(i-2, i-1, i+1, i+2)의 최댓값을 구함.
 *                비교 대상이 4개로 고정되어 있어 슬라이딩 윈도우보다 직접 비교가 효율적임.
 * - 시간 복잡도 : O(N) (N은 건물의 개수, 최대 1,000 / 각 루프당 상수 시간 비교)
 *
 * @see      <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh&categoryId=AV134DPqAA8CFAYh&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-07
 */
 
public class SWEA_D3_1206_View {
    static final int TESTCASE_NUM = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = TESTCASE_NUM;

        for (int t=1; t<=tc; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] buildings = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
            }

            int viewCount = getViewCount(N, buildings);
            bw.write("#"+t+" "+viewCount+"\n");
        }

        bw.flush();
        bw.close();
    }

    private static int getViewCount(int N, int[] buildings) {
        int count = 0;

        for (int i=2; i<N-2; i++) {
            // 현재 건물의 앞 뒤 2칸 거리에서 가장 높은 건물 찾기
            int around = Math.max(buildings[i-1], buildings[i-2]);
            around = Math.max(around, buildings[i+1]);
            around = Math.max(around, buildings[i+2]);

            // 주변 2칸 거리의 건물 중 가장 높은 건물과 내 건물 간의 차이만큼 조망 확보
            if (buildings[i] > around) count += buildings[i] - around;
        }

        return count;
    }
}
