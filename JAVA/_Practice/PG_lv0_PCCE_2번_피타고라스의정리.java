package JAVA._Practice;

/**
 * [PG] PCCE. 2번 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 17.
 */

import java.util.Scanner;

public class PG_lv0_PCCE_2번_피타고라스의정리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int c = sc.nextInt();

		int b_square = c*c - a*a;

		System.out.println(b_square);
	}
}
