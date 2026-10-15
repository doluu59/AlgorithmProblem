package JAVA.Simulation;

/**
 * [SWEA] 5658. 보물상자비밀번호 (모의)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    2026-05-14
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_모의_5658_보물상자비밀번호 {
	static int N, K;
	static int wordLen;
	static long ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			wordLen = N/4;	// 네 그룹으로 나눌 때 한 숫자의 길이
			ans = -1;
			TreeSet<Long> set = new TreeSet<>();	//10진수로 변환한 수가 중복 없이 작은 순서로 저장
			String input = br.readLine();	// 문자열 전체
			for (int r=0; r<wordLen; r++) {	// 문자열을 4 단어로 나눴을 때의 각 숫자의 글자수 만큼 회전
				for (int n=0; n<4; n++) {
					// 문자열을 4개의 16진수 문자열로 바꾸기
					String hexnum = input.substring(n*wordLen, wordLen*(n+1));
					// 16진수를 10진수 long으로 변환 후 집합에 넣기
					set.add(Long.parseLong(hexnum, 16));
				}

				if (r==wordLen) break;	//마지막 문자열은 회전할 필요 없음
				// 문자열 회전
				Deque<Character> deque = new ArrayDeque<>();
				for (int i=0; i<N; i++) {
					deque.offerLast(input.charAt(i));	//문자열의 각 글자를 덱에 넣기
				}
				// 덱에서 마지막꺼 빼서 젤 앞으로 넣기 => 회전
				deque.offerFirst(deque.pollLast());
				// char Collection을 다시 string으로
				StringBuilder sb2 = new StringBuilder();
				for(char ch: deque) {
					sb2.append(ch);
				}
				input = sb2.toString();
			}
			// 트리 셋에는 작은 순서로 저장되어 있으니 반대로 인덱스 세서 원하는 수 저장
			int find = set.size()-K+1;
			int idx = 1;
			for (Long num: set) {
				if (idx++==find) {
					ans = num;
					break;
				}
			}
			//output
			sb.append("#"+tc+" "+ans+"\n");
		}
		//print
		System.out.println(sb.toString());
	}
}
