package JAVA.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S2_2961_도영이가만든맛있는음식 {
    static int min = Integer.MAX_VALUE;		// 맛의 최소값 (구하고자 하는 정답)
    static int N;							// 재료 개수
    static int soursum, bittersum;			// 신맛의 합계, 쓴맛의 합계,
    static int[][] sourNbitter;				// 재료의 신맛과 쓴맛(input)을 담을 2차원 배열
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //input
        N = Integer.parseInt(br.readLine());
        sourNbitter = new int[N][2];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sourNbitter[i][0] = Integer.parseInt(st.nextToken());
            sourNbitter[i][1] = Integer.parseInt(st.nextToken());

        }

        // 4. 아무것도 안고르고 호출
        Subset(0, 1, 0, 0);

        //output
        bw.write(Integer.toString(min));
        //closing
        bw.flush();
        bw.close();
        br.close();
    }
    /**
     * @param cnt : 함수가 호출 되었을 때 이전까지 센 개수
     * @param soursum : 여태 사용한 재료들의 신맛 합계
     * @param bittersum : 여태 사용한 재료들의 쓴맛 합계
     * @param usedcount : 사용한 재료 개수 (최소 한 개의 재료를 사용해야 하기 때문에 )
     */
    private static void Subset(int cnt, int soursum, int bittersum, int usedcount) {
        // 1. 종료 조건
        if (cnt==N) {
            if (usedcount!=0) {
                // 3. 맛 차이 최소 값  업데이트
                int taste = Math.abs(soursum-bittersum);
                min = taste<min? taste : min;
            }
            return;
        }
        // 2. 맛 계산
        // 이번 재료를 썼을 때,
        Subset(cnt+1, soursum*sourNbitter[cnt][0], bittersum+sourNbitter[cnt][1], usedcount+1);
        // 이번 재료를 안 썼을 때
        Subset(cnt+1, soursum, bittersum, usedcount);
    }
}
