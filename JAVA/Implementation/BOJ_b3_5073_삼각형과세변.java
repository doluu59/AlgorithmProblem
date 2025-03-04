package JAVA.Implementation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @from BOJ (코테 비슷했던 문제들)
 * @index 5073
 * @title 삼각형과 세 변
 * @grade Bronze 3
 * @classification Implementation
 * @solve 그냥 구함
 */

public class BOJ_b3_5073_삼각형과세변 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int[] line = new int[3];

        while (true) {
            st = new StringTokenizer(br.readLine());

            for (int i=0; i<3; i++) {
                line[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(line);

            // 종료
            if (line[0]==0 && line[1]==0 && line[2]==0) break;

            // Invalid
            if (line[0] + line[1] <= line[2]) {
                bw.write("Invalid"+"\n");
                continue;
            }

            if (line[0]==line[1] && line[0] == line[2]) {
                bw.write("Equilateral" + "\n");
                continue;
            }

            if (line[0]==line[1] || line[0] == line[2] || line[1] == line[2]) {
                bw.write("Isosceles " + "\n");
                continue;
            }

            bw.write("Scalene " + "\n");
        }
        // output
        bw.flush();
        bw.close();
    }
}
