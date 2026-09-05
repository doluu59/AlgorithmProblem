package JAVA._Practice;

/**
 * [PG] 기초. 문자열반복해서출력하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 2.
 */

import java.util.Scanner;

public class PG_lv0_기초_문자열반복해서출력하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int n = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) {
			sb.append(str);
		}

		System.out.println(sb.toString());
	}
}
