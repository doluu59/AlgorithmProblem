package JAVA._Practice;

/**
 * [PG] 입문. 숨어있는숫자의덧셈2 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 13.
 */
 
public class PG_lv0_입문_숨어있는숫자의덧셈2 {
	public static void main(String[] args){
	}
	static class Solution {
		public int solution(String my_string) {
			int answer = 0;
			String straight="";

			for(int i=0;i<my_string.length();i++){
				char c=my_string.charAt(i);

				if (c >= '0' && c <= '9'){
					straight+=c;
				}
				else if(!straight.isEmpty()){
					answer+=Integer.parseInt(straight);
					straight="";
				}
			}

			if(!straight.isEmpty())
				answer+=Integer.parseInt(straight);

			return answer;
		}
	}
}
