package JAVA.SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @from BOJ
 * @index 12891
 * @title DNA 비밀번호
 * @grade Silver 2
 * @classification 슬라이딩 윈도우
 * @solve 만들고자 하는 비밀번호의 길이 만큼의 부분 문자열을 슬라이딩 윈도우로 만들기
 *          슬라이딩 윈도우 밀면서 조건을 만족하는지 확인
 */
public class BOJ_s2_12891_DNA비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 전체 DNA 문자열
        String dna = br.readLine();
        // 'A' -> 0, 'C' -> 1, 'G' -> 2, 'T' -> 3
        int[] nums = new int[N];    // dna 문자열을 숫자로 변환
        for (int i=0; i<N; i++) {
            switch (dna.charAt(i)) {
                case 'A' :
                    nums[i] = 0;
                    break;
                case 'C' :
                    nums[i] = 1;
                    break;
                case 'G' :
                    nums[i] = 2;
                    break;
                case 'T' :
                    nums[i] = 3;
                    break;
            }
        }

        // 필요로 하는 DNA 문자 개수
        int[] required = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<required.length; i++) {
            required[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        int ans = 0;
        // 0부터 시작하는 길이가 P인 부분 문자열 (슬라이딩 윈도우 초기화)
        for (int i=0; i<P; i++) {
            required[nums[i]]--;
        }
        // 슬라이딩 윈도우 이동하면서 체크
        for (int i=0; i+P <= N; i++) {
            // 슬라이딩 윈도우 한칸 밀기
            if (i>0) {
                required[nums[i-1]]++;
                required[nums[P-1+i]]--;
            }
            // 조건을 만족 하는 지 체크
            if (required[0] <= 0 &&
            required[1] <= 0 &&
                    required[2] <= 0 &&
                    required[3] <= 0) {
                ans++;
            }
        }
        // output
        System.out.println(ans);
    }
}
