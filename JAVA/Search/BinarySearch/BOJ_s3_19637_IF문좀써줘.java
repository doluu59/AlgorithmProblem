package yoo.algorithm.JAVA.Search.BinarySearch;

import java.io.*;
import java.util.*;

/**
 * @from BOJ
 * @index 19637
 * @title IF문 좀 대신 써줘
 * @grade Silver 3
 * @classification Binary Search
 * @solve 각 칭호의 제한 레벨을 중앙 값으로 둠.
 */

public class BOJ_s3_19637_IF문좀써줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> limits = new ArrayList<>();

        HashMap<Integer, String> levels = new HashMap<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String level = st.nextToken();
            int limit = Integer.parseInt(st.nextToken());

            // 이미 같은 제한 있으면 제외
            if (levels.containsKey(limit)) continue;

            limits.add(limit);
            levels.put(limit, level);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i=0; i<M; i++) {
            int character = Integer.parseInt(br.readLine());

            int lowerBound = 0;
            int upperBound = limits.size()-1;
            // 이분 탐색
            while(lowerBound < upperBound) {        // 이분 탐색 종료 조건 - 경계가 교차하거나 겹칠 때
                // 캐릭터가 최저 칭호보다 작으면 최저 칭호 주기
                if (character <= limits.get(lowerBound)) break;
                
                // 중앙 값
                int mid = (lowerBound + upperBound)/2;

                // 이분 탐색
                if (character > limits.get(mid)) {
                    lowerBound = mid+1;
                } else {
                    upperBound = mid;
                }
            }

            // output
            int limit = limits.get(lowerBound);
            bw.write(levels.get(limit)+"\n");
        }

        bw.flush();
        bw.close();
    }
}