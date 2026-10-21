package JAVA._Practice;

/**
 * [PG] 입문. 종이자르기 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : M*N 사이즈의 종이를 모두 1*1사이즈로 만들기 위해 필요한 가위질 횟수
 * - 풀이 전략   : 겹쳐 자르지 못하기 때문에 넓이를 M*N을 1로 만든다 생각하고 M*N-1로 수식이 됨
 * - 시간 복잡도 : O(1)
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 10. 21.
 */
 
public class PG_lv0_입문_종이자르기 {
	public static void main(String[] args){
	}
	static class Solution {
		public int solution(int M, int N) {
			return M*N-1;
		}
	}
}
