package JAVA.DataStructure.Hash.Map;

/**
 * [PG] 입문. 모스부호1 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 알파벳에 대응하는 모스부호 맞춰서 변환하기
 * - 풀이 전략   : HashMap
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 20.
 */

import java.util.*;

public class PG_lv0_입문_모스부호1 {
	public static void main(String[] args){
	}

	static class Solution {
		public String solution(String letter) {
			Map<String, Character> map = new HashMap<>() {{
				put(".-", 'a');
				put("-...", 'b');
				put("-.-.", 'c');
				put("-..", 'd');
				put(".", 'e');
				put("..-.", 'f');
				put("--.", 'g');
				put("....", 'h');
				put("..", 'i');
				put(".---", 'j');
				put("-.-", 'k');
				put(".-..", 'l');
				put("--", 'm');
				put("-.", 'n');
				put("---", 'o');
				put(".--.", 'p');
				put("--.-", 'q');
				put(".-.", 'r');
				put("...", 's');
				put("-", 't');
				put("..-", 'u');
				put("...-", 'v');
				put(".--", 'w');
				put("-..-", 'x');
				put("-.--", 'y');
				put("--..", 'z');
			}};
			StringTokenizer st = new StringTokenizer(letter);
			StringBuilder sb = new StringBuilder();

			while(st.hasMoreTokens()) {
				String morse = st.nextToken();
				sb.append(map.get(morse));
			}

			return sb.toString();
		}
	}
}
