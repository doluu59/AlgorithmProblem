package JAVA.StackQueue.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class SWEA_D4_1218_괄호짝짓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc=1; tc<=10; tc++) {
            int n = Integer.parseInt(br.readLine());
            char[] brackets = br.readLine().toCharArray();
            boolean isValid=true;
            Stack<Character> stack = new Stack<>();
            /**
             * 문자열을 쭉 읽으면서
             * 괄호 조건에 따라 동작
             * 열린 괄호 : push
             * 닫힌 괄호 : 스택이 비었으면 유효X,
             * 			안 비었으면 pop 해서 짝이 맞는 지 확인	=>	짝이 맞으면 그대로
             * 											짝이 다르면 유효X
             * 한 문자를 읽고난 후 유효하지 않다면 이미 유효하지 않은 문자열
             * 	=> 반복 탈출
             * 유효 하다면 다음 문자 읽기
             */
            for (char ch: brackets) {
                switch (ch) {
                    //열린 문자일 때
                    case '(': case '[': case '{': case '<':
                        stack.push(ch);
                        break;
                    //닫힌 문자일 때
                    default:
                        //pop
                        if (!stack.isEmpty()) {
                            char pop = stack.pop();
                            int pair= ch==')'?1:2;	//()만 ascii 1차이, 나머진 2차이
                            if (ch-pop==pair) isValid=false;	//짝이 안맞음 => 유효 X
                        } else {
                            isValid=false;			//닫힌 괄호라서 열린 괄호 꺼내야 하는데 스택이 빔 => 유효 X
                        }
                        break;
                }
                //틀린 게 생겼다면 반복 중지
                if (!isValid) break;
            }
            //모든 문자 탐색 후에 스택에 남아있는 게 있다면 짝이 안맞기에 false;
            if (!stack.isEmpty()) isValid=false;
            //output
            int ans = isValid?1:0;
            bw.write("#"+tc+" "+ans+"\n");
        }
        //closing
        bw.flush();
        bw.close();
        br.close();
    }
}
