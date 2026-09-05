package JAVA.Recursive;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_S5_17478_재귀함수가뭔가요 {
    //재귀 반복할 N 저장 위한 변수
    static int N = -1;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //가장 처음 함수 시작할 때만 나오는 문자열
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        Recursive(N);	//N번 재귀 호출
        //전체 재귀 끝나면 만들어진 문자열 출력
        System.out.println(sb.toString());
    }

    public static void Recursive(int n) {
        PrintRe(n, "\"재귀함수가 뭔가요?\"\n");
        //재귀 마지막일 때와 아닐 때 구분.
        if (n==0) {
            //내가 기저일 때
            PrintRe(n, "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        } else {
            //내가 기저가 아닐 때
            PrintRe(n, "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            PrintRe(n, "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            PrintRe(n, "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            Recursive(n-1);
        }
        //재귀 했던 함수가 끝나고 현재 내 함수를 끝내기 전에 처리할 문자열
        PrintRe(n, "라고 답변하였지.\n");
        return;
    }

    //문자열 앞에 '_' 붙여주기 위한 함수
    public static void PrintRe(int n, String str) {
        for (int i=0; i<N-n; i++) {
            sb.append("____");
        }
        sb.append(str);
    }
}
