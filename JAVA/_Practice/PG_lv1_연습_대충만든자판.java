package JAVA._Practice;

/**
 * [PG] 대충만든자판 | 연습 · Lv.1
 *
 * @category 
 * @algorithm 
 *
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 * - 탐구 과정 (생략 가능)
 *
 * @author   ysyoo
 * @see      <a href="">Problem Link</a>
 */
 
public class PG_lv1_연습_대충만든자판 {
	class Solution {
		public int[] solution(String[] keymap, String[] targets) {
			int[] answer = new int[targets.length];
			for(int i = 0; i < targets.length; i++) {
				for(char c : targets[i].toCharArray()) {
					int press = Integer.MAX_VALUE;
					for(String k : keymap) {
						for(int j = 0; j < k.length(); j++) {
							if(c == k.charAt(j)) {
								press = Math.min(press, j);
								break;
							}
						}
					}
					if(press == Integer.MAX_VALUE) {
						answer[i] = -1;
						break;
					}
					else answer[i] += press + 1;
				}
			}
			return answer;
		}
	}
}
