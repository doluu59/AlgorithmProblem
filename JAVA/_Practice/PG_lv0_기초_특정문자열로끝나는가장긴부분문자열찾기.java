package JAVA._Practice;

/**
 * [PG] 기초. 특정문자열로끝나는가장긴부분문자열찾기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 8. 26.
 */
 
public class c {
	public static void main(String[] args){
	}
	static class Solution {
		public String solution(String myString, String pat) {
			String answer = "";
			int len = pat.length();
			// 뒤에서부터 pat와 같은 길이만큼 잘라서 문자열 비교
			for (int i=myString.length(); i>=len-1; i--) {
				if (pat.equals(myString.substring(i-len, i))) {
					answer = myString.substring(0, i);
					break;
				}
			}

			return answer;
		}
	}
}
