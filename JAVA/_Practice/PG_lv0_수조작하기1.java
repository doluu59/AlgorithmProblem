package JAVA._Practice;

/**
 * @author |   ysyoo
 * @platform |   문제 출처 (Baekjoon / Programmers / LeetCode / Softeer ...)
 * @index |   문제 번호
 * @title |   제목
 * @link |   문제 링크
 * @level |   난이도 (Gold 5, Lv.2, Medium ...)
 * @approach |   한 줄 문제 요약
 * @algorithm |   문제 유형 (DP, Graph, Simulation ...)
 * @technique |   사용된 기법 (Bit masking, stream ...)
 */
public class PG_lv0_수조작하기1 {
    public static void main(String[] args) {

    }

    class Solution {
        public int solution(int n, String control) {
            for (int i=0; i<control.length(); i++) {
                switch(control.charAt(i)) {
                    case 'w':
                        n++;
                        break;
                    case 's':
                        n--;
                        break;
                    case 'd':
                        n+=10;
                        break;
                    case 'a':
                        n-=10;
                        break;
                }
            }
            return n;
        }
    }
}
