package JAVA.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_1208_Flatten {
    static final int WIDTH = 100;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //tc 10회 고정
        for (int tc=1; tc<=10; tc++) {
            StringBuilder sb = new StringBuilder();
            //output setting
            sb.append("#"+tc+" ");

            //input
            int N = Integer.parseInt(br.readLine());						//dump counts
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[WIDTH];										//box heights arr
            for (int i=0; i<WIDTH; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //N times repeat
            // each time, sorting -> Max--, min++
            for (int i=0; i<N; i++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[WIDTH-1]--;
            }

            // result
            Arrays.sort(arr);
            sb.append(arr[WIDTH-1]-arr[0]);		//sorting 후, max와 min은 맨 뒤, 맨 앞에 저장 되어 있음.
            sb.append("\n");
            bw.write(sb.toString());

        }
        bw.close();
        br.close();
    }
}
