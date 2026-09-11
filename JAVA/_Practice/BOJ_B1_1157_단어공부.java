package JAVA._Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B1_1157_단어공부 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        char ans = ' ';
        int[] alphaCnt = new int[26];
        char[] str = br.readLine().toCharArray();
        //문자 읽으면서 사용된 알파벳 횟수 늘려주기
        for (int i=0; i<str.length; i++) {
            int alphabet = (str[i]>='a' && str[i]<='z') ? str[i]-'a' : str[i]-'A';
            alphaCnt[alphabet]++;
        }
        //가장 많이 사용된 알파벳 찾기
        for (int i=0; i<26; i++) {
            if (alphaCnt[i]==max) ans = '?';
            else if(alphaCnt[i]>max) {
                max = alphaCnt[i];
                ans = (char) ('A'+i);
            }
        }
        System.out.println(ans);
    }

}
