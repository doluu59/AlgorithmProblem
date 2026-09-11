package JAVA._Practice;

/**
 * [PG] 입문. 합성수찾기 (lv0)
 * @category Math
 * @implNote
 * - 문제 요약   : 약수 개수 찾기
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 7. 12.
 */
 
public class PG_lv0_입문_합성수찾기 {
	public static void main(String[] args) {
	}
	class Solution {
		public int solution(int n) {
			int answer = 0;
			if (n<4) return 0;
			for (int i=4; i<=n; i++) {
				int cnt = 2;
				for (int j=2; j<i; j++) {
					if (i%j==0) cnt++;
				}
				if (cnt>2) answer++;
			}
			return answer;
		}
	}
}
