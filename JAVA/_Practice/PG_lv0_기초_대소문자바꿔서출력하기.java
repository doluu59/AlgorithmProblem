package JAVA._Practice;

/**
 * [PG] 기초. 대소문자바꿔서출력하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 4.
 */

import java.util.Scanner;

public class PG_lv0_기초_대소문자바꿔서출력하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		StringBuilder sb = new StringBuilder();
		for (char ch : str.toCharArray()) {
			if (ch >= 'a' && ch <= 'z') sb.append((char)(ch-'a'+'A'));
			else sb.append((char)(ch-'A'+'a'));
		}

		System.out.println(sb.toString());
	}
}
