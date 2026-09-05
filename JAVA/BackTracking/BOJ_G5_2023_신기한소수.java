package JAVA.BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_G5_2023_신기한소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int NdigitNum = (int) Math.pow(10, N-1);


        for (int i=2*NdigitNum; i<8*NdigitNum; i++) {
            if (!isPrime(i)) {
                continue;
            } else sb.append(i+"\n");// bw.write(i+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    private static boolean isPrime(int n) {

        if (n<2) return false;
        for (int i=2; i*i<=n; i++) {
            if (n%i==0) return false;
        }
        //재귀로
        if (n<10) return true;
        else return isPrime(n/10);
    }
}
