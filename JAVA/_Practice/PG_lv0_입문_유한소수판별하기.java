package JAVA._Practice;

/**
 * [PG] 입문. 유한소수판별하기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 14.
 */
 
public class PG_lv0_입문_유한소수판별하기 {
	public static void main(String[] args){
	}
	static class Solution {
		 public int solution(int a, int b) {
			 int answer = 1;
			 int max = 0;
			 for(int i =1; i<=a; i++){
				 if(a%i ==0 && b%i ==0) max= i;
			 }

			 b /= max;

			 while(b>1){
				 if(b%2==0){
					 b /= 2;
				 }else if(b%5==0){
					 b /= 5;
				 }else {
					 return 2;
				 }
			 }

			 return answer;
		 }
	 }
}
