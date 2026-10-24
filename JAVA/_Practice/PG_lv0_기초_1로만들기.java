package JAVA._Practice;

public class PG_lv0_기초_1로만들기 {
	public static void main(String[] args){
	}
	class Solution {
		public int solution(int[] num_list) {
			int answer = 0;
			for (int num : num_list) {
				answer += getResult(num);
			}
			return answer;
		}

		int getResult(int num) {
			int cnt = 0;
			while (num!=1) {
				if (num%2==0) num/=2;
				else num = (num-1) / 2;
				cnt++;
			}
			return cnt;
		}
	}
}
