package JAVA.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_15649_N과M {
    static int N, M;
    static int[] range;
    static boolean[] isUsed;
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //가능한 숫자 범위 담을 배열, 그 숫자가 사용됐는지 체크 하는 배열
        range = new int[N];
        isUsed = new boolean[N];
        for(int i=1; i<=N; i++) {
            range[i-1] = i;
        }
        //순열 만들기
        permutation(new int[M], 0);
    }
    private static void permutation(int[] permResult, int cnt) {
        //현재 까지의 순열에 담긴 개수가 목표치인 M이 되면 순열 출력하고 종료
        if (cnt == M) {
            for (int i:permResult)
                System.out.print(i+" ");
            System.out.println();
            return;
        }
        //순열에 사용가능한 범위를 반복
        for (int i=0; i<N; i++) {
            //사용된 숫자라면 다른 숫자로
            if(isUsed[i]) continue;
            //순열에 숫자 추가, 넣어준 숫자는 사용했다고 마스킹
            permResult[cnt] = range[i];
            isUsed[i] = true;
            //현재까지 담은 순열로 재귀 호출
            permutation(permResult, cnt+1);
            //재귀가 끝나고 돌아온 뒤에는 내가 썼던 숫자 반납하고 다음 반복문으로.
            isUsed[i] = false;
        }

    }
}
