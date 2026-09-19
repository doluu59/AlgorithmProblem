package JAVA._Practice;

/**
 * [PG] PCCE. 4번 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 18.
 */

import java.util.Scanner;

public class PG_lv0_PCCE_4번_병과분류 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String code = sc.next();
		String lastFourWords = code.substring(code.length()-4, code.length());

		if(lastFourWords.equals("_eye")){
			System.out.println("Ophthalmologyc");
		} else if(lastFourWords.equals("head")){
			System.out.println("Neurosurgery");
		} else if(lastFourWords.equals("infl")){
			System.out.println("Orthopedics");
		} else if( lastFourWords.equals("skin")) {
			System.out.println("Dermatology");
		} else {
			System.out.println("direct recommendation");
		}
	}
}