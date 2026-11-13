package JAVA._Practice;

/**
 * [PG] 숫자짝꿍 | 연습 · Lv.1
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
 
public class PG_lv1_연습_숫자짝꿍 {
	class Solution {
		public String solution(String X, String Y) {
			StringBuilder answer = new StringBuilder();
			int[] x = {0,0,0,0,0,0,0,0,0,0};
			int[] y = {0,0,0,0,0,0,0,0,0,0};
			for(int i=0; i<X.length();i++){
				x[X.charAt(i)-48] += 1;
			}
			for(int i=0; i<Y.length();i++){
				y[Y.charAt(i)-48] += 1;
			}

			for(int i=9; i >= 0; i--){
				for(int j=0; j<Math.min(x[i],y[i]); j++){
					answer.append(i);
				}
			}
			if("".equals(answer.toString())){
				return "-1";
			}else if(answer.toString().charAt(0)==48){
				return "0";
			}else {
				return answer.toString();
			}
		}
	}
}
