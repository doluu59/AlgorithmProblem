package JAVA._Practice;
/**
 * BOJ_B5_10872_팩토리얼
 * 재귀
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10872_B5_팩토리얼 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		System.out.println(factorial(N));
	}
	private static int factorial(int n) {
		if (n<=1) return 1;
		return n*factorial(n-1);
	}
}
