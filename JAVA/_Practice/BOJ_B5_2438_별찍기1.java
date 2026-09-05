package JAVA._Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_B5_2438_별찍기1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=N; i++) {
			for (int j=0; j<i; j++) sb.append("*");
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush(); bw.close(); br.close();
	}
}