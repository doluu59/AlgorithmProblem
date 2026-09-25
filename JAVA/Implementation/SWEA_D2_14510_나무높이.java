package JAVA.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SWEA_D2_14510_나무높이 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=TC; tc++) {
            int ans=0;
            int N = Integer.parseInt(br.readLine());
            int[] woods = new int[N];
            for (int i=0; i<N; i++) {
                woods[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(woods);
            int max = woods[N-1];
            for (; ans < N; ans++) {
                for (int i=N-2; i>0; i--) {
                    if (ans % 2==1) {
                        if (max-woods[i]>2) {
                            woods[i]++;
                            break;
                        }
                        else continue;
                    } else {
                        if (max-woods[i]>1) {
                            woods[i]+=2;
                            break;
                        }
                    }
                }
            }
            sb.append("#"+tc+" "+ans+"\n");
        }
        bw.write(sb.toString());
        bw.flush(); bw.close(); br.close();
    }
}
