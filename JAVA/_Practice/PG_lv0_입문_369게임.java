package JAVA._Practice;

public class PG_lv0_입문_369게임 {
	public static void main(String[] args) {
	}

	static class Solution {
		public int solution(int order) {
			int answer = 0;
			String str = String.valueOf(order);
			for (int i=0; i<str.length(); i++) {
				switch (str.charAt(i)) {
					case '3': case '6': case '9':
						answer ++;
						break;
				}
			}
			return answer;
		}
	}
}
