package JAVA._Practice;

/**
 * [PG] PCCE. 8번 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 20.
 */
 
public class PG_lv0_PCCE_8번_닉네임규칙 {
	public static void main(String[] args){
	}
	class Solution {
		public String solution(String nickname) {
			String answer = "";
			for(int i=0; i<nickname.length(); i++){
				if(nickname.charAt(i) == 'l'){
					answer += "I";
				}
				else if(nickname.charAt(i) == 'w'){
					answer += "vv";
				}
				else if(nickname.charAt(i) == 'W'){
					answer += "VV";
				}
				else if(nickname.charAt(i) == 'O'){
					answer += "0";
				}
				else{
					answer += nickname.charAt(i);
				}
			}
			while (answer.length() < 4){
				answer += "o";
			}
			if(answer.length() > 8){
				answer = answer.substring(0, 8);
			}
			return answer;
		}
	}
}
