package JAVA._Practice;

public class PG_lv0_기초_가까운1찾기 {
	public static void main(String[] args){
	}

	class Solution {
		public int solution(int[] arr, int idx) {
			int answer = 0;
			for (int i=idx; i<arr.length; i++) {
				if (arr[i] == 1) return i;
			}
			return -1;
		}
	}
}
