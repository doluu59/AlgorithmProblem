package JAVA._Practice;

/**
 * [PG] 기초. 왼쪽오른쪽 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 6.
 */

import java.util.*;

public class PG_lv0_기초_왼쪽오른쪽 {
	public static void main(String[] args){
	}

	class Solution {
		public String[] solution(String[] str_list) {
			List<String> list = new ArrayList<>();

			for (int i=0; i<str_list.length; i++) {
				if (str_list[i].equals("l")) {
					for (int j=0; j<i; j++) {
						list.add(str_list[j]);
					}
					break;
				}

				if (str_list[i].equals("r")) {
					for (int j=i+1; j<str_list.length; j++) {
						list.add(str_list[j]);
					}
					break;
				}
			}

			String[] answer = new String[list.size()];
			for (int i=0; i<list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;
		}
	}
}
