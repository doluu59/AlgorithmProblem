package JAVA.BruteForce;
/**
 * BOJ_S1_1080_행렬
 * 브루트포스
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_1080_행렬 {
	static int[][] A,B;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//input
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		B = new int[N][M];
		for (int i=0; i<N; i++) {						//A행렬 input
			char[] str = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				A[i][j] = str[j]-'0';
			}
		}
		for (int i=0; i<N; i++) {						//B행렬 input
			char[] str = br.readLine().toCharArray();	
			for (int j=0; j<M; j++) {
				B[i][j] = str[j]-'0';
			}
		}
		//완전 탐색하며 원소 다를 때마다 뒤집기~
		exit:
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (A[i][j] != B[i][j]) {		//두 행렬이 다른 원소가 있으면 뒤집기
					if (i+2>=N || j+2>=M) {		// 이 때, 인덱싱 벗어나는 애가 생긴다는 건 이쪽 3*3은 뭘해도 답 안됨.
						cnt=-1;
						break exit;
					}
					flip(i, j);		// (i,j)~(i+2,j+2)까지 3*3 뒤집기
				}
			}
		}
		//output
		System.out.println(cnt);
	}
	//파라미터로 받은 좌표부터 3*3크기를 뒤집기
	private static void flip(int i, int j) throws ArrayIndexOutOfBoundsException {
		for (int ni=0; ni<3; ni++) {
			for (int nj=0; nj<3; nj++) {
				A[ni+i][nj+j] = A[ni+i][nj+j]==1?0:1;	//뒤집기
			}
		}
		cnt++;	//3*3 뒤집은 횟수 추가
	}
}