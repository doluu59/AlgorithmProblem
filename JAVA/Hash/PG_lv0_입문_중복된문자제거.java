package JAVA.Hash;

/**
 * [PG] 입문. 중복된문자제거 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : Linked Hash Set
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 7.
 */

import java.util.*;

public class PG_lv0_입문_중복된문자제거 {
	public static void main(String[] args){
	}

	class Solution {
		public String solution(String my_string) {
			StringBuilder sb = new StringBuilder();
			Set<Character> set = new LinkedHashSet<>();
			for (char c : my_string.toCharArray()) {
				set.add(c);
			}
			for (Character c : set) {
				sb.append(c);
			}
			return sb.toString();
		}
	}
}
