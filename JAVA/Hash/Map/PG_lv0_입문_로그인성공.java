package JAVA.Hash.Map;

/**
 * [PG] 입문. 로그인성공 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 주어진 문자열과 일치하는 문자열 배열이 있는지 확인
 * - 풀이 전략   : HashMap
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 1.
 */

import java.util.*;

public class PG_lv0_입문_로그인성공 {
	public static void main(String[] args){
	}

	class Solution {
		public String solution(String[] id_pw, String[][] db) {
			// input
			Map<String, String> map = new HashMap<>();
			for (String[] user : db) {
				map.put(user[0], user[1]);
			}
			// id fail
			if (!map.containsKey(id_pw[0])) return "fail";
			// login success or fail
			if (map.get(id_pw[0]).equals(id_pw[1])) return "login";
			else return "wrong pw";
		}
	}
}
