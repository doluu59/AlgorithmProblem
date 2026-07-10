package JAVA._Practice;

public class PG_lv0_기초_피자나눠먹기2 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(int n) {
			int answer = 0;
			for (int i=0; i<=100; i++) {
				if (++answer * 6 % n == 0) return answer;
			}
			return answer;
		}
	}
}
