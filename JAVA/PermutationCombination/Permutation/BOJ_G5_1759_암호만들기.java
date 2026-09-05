package JAVA.PermutationCombination.Permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_1759_암호만들기 {
	static char[] output;
	static char[] charRange;
	static boolean[] isSelected;
	static int L, C;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		//input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		charRange = new char[C];
		isSelected = new boolean[C];
		output = new char[L];
		
		String[] tmp = br.readLine().split(" ");
		for (int i=0; i<C; i++) {
			charRange[i] = tmp[i].charAt(0);
		}
		
		
		//sorting
		Arrays.sort(charRange);
		
		//순열로 출력
		permutation(0);
		
	}

	private static void permutation(int cnt) {
		if (cnt == L) {
			//조건 완성되면
			if(isValid(output)) sb.append(output.toString()+"\n");
		}
		//
		for (int i=0; i<C; i++) {
			isSelected[C] = true;
			output[cnt] = charRange[C];
			permutation(cnt+1);
			isSelected[C] = false;
		}
	}
	
	//순열로 만든 문자열이 모음 1개, 자음 2개 조건 성립하는지
	private static boolean isValid(char[] str) {
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		int vcount = 0;	//모음 개수
		for (char ch:str) {
			//문자열에서 하나의 문자가 모음인지 체크
			boolean isVowel = false;
			for (char vowel: vowels) {
				if(vowel==ch) {
					isVowel = true;
					break;
				}
			}
			if (isVowel) vcount++;
		}
		if (vcount >= 1 && L-vcount >= 2) return true;
		else return false;
	}
	
}
