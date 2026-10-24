package JAVA._Practice;

/**
 * [PG] PCCE. 3번 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 25.
 */

import java.util.Scanner;

public class PG_lv0_PCCE_3번_수나누기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int answer = 0;

		while (number > 0) {
			answer += number % 100;
			number /= 100;
		}

		System.out.println(answer);
	}
}