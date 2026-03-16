package JAVA._Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_B1_1546_평균 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] scores = new int[N];
		for (int i=0;i<N;i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		int max = (int)Arrays.stream(scores).max().getAsInt();
		double avg = (double)Arrays.stream(scores).sum()/max*100/N;
		System.out.println(avg);
	}

}
