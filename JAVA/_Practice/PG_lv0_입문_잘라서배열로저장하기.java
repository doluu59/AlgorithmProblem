package JAVA._Practice;

/**
 * [PG] 입문. 잘라서배열로저장하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 1.
 */
 
public class PG_lv0_입문_잘라서배열로저장하기 {
	public static void main(String[] args){
	}
	class Solution {
		public String[] solution(String my_str, int n) {
			int len = my_str.length();
			int size = len%n == 0 ? len/n : len/n+1;
			String[] answer = new String[size];
			for (int i=0; i<len; i+=n) {
				int end = i+n > len ? len : i+n;
				answer[i/n] = my_str.substring(i, end);
			}
			return answer;
		}
	}
}
