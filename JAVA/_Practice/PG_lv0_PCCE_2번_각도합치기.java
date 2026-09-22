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
 * @since    26. 9. 21.
 */

import java.util.Scanner;

public class PG_lv0_PCCE_2번_각도합치기 {
	public static void main(String[] args){
	}

	public class Solution {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int angle1 = sc.nextInt();
			int angle2 = sc.nextInt();

			int sum_angle = (angle1 + angle2)%360;
			System.out.println(sum_angle);
		}
	}
}
