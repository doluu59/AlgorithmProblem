package JAVA.Recursive;

/**
 * @author |   ysyoo
 * @platform |   SW Expert Academy
 * @index |   1289
 * @title |   원재의 메모리 복구하기
 * @link |   https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN&categoryId=AV19AcoKI9sCFAZN&categoryType=CODE&problemTitle=1289&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @level |   Difficulty 3
 * @approach |   한 줄 문제 요약
 * @algorithm |   재귀
 * @technique |   사용된 기법 (Bit masking, stream ...)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_D3_1289_원재의메모리복구하기 {
    static int ans = 0;
    static char[] mem = null;		//tc마다 입력받는 메모리
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트케이스 수 Input
        int TC = Integer.parseInt(br.readLine());

        //tc
        for (int tc=1; tc<=TC; tc++) {
            ans = 0;							//매 테스트 케이스마다 바꾼 횟수 초기화
            mem = br.readLine().toCharArray();	//읽어서 문자열의 각 문자를 char[]에 저장

            Recursive(mem, 0, '0');				// 0(초기화 상태)에서 원래 상태로 돌아가기 위한 재귀

            System.out.println("#"+tc+" "+ans);
        }
    }
    /**
     * (bit 하나를 기억해서 값을 원래 문자열과 일치하는 값으로 바꾸는 경우 이후의 모든 비트가 그 값으로 통일 된다는 것은
     *  문자열을 앞에서부터 하나씩 읽으면서 내가 지정한 문자 (0)과 다르다면, 다음 문자열부터는 다른 문자(1)과 비교한다는 것. )
     *
     * 문자열을 맨 앞에서 부터 읽으면서 다음 문자열을 읽기 위해 재귀 호출
     * 0...0을 원래 문자열로 바꾸기 위해서는
     * 앞에서부터 한 문자씩 읽으면서 현재 비교를 위한 문자와 다르다면
     * 바꾼 횟수(ans) ++, 다음 index부터는 현재 문자와 반대 문자로 비교
     * @param mem : 원래의 정답 문자열
     * @param idx : 내가 이번에 볼 문자열 index
     * @param cur : 현재 내가 바꿔둔 문자
     */
    public static void Recursive(char[] mem, int idx, char cur) {
        //문자열의 길이만큼 index가 왔다 => 다 읽었다.
        if (idx == mem.length) {
            return;
        }
        //현재 내가 기억한 문자와 현재 문자열이 일치하면 바꾸지 않고 그대로 진행
        if (mem[idx++]==cur) {
            Recursive(mem, idx, cur);
        } else {
            //내가 현재 기억한 문자와 실제 문자열이 다르다면 바꾼 횟수 ++, 비교할 기억한 문자를 바꿔줌.
            ans++;
            if (cur=='0') cur = '1'; else cur = '0';
            Recursive(mem, idx, cur);
        }
    }
}
