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
 * @since    26. 9. 16.
 */

import java.util.Scanner;

public class PG_lv0_PCCE_3번_나이계산  {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		String age_type = sc.next();
		int answer = 0;

		if (age_type.equals("Korea")) {
			answer = 2030 - year + 1;
		}
		else if (age_type.equals("Year")) {
			answer = 2030 - year;
		}
		System.out.println(answer);
	}
}
