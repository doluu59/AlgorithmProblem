package JAVA._Practice;
 
public class PG_lv0_기초_조건에맞게수열변환하기1 {
	public static void main(String[] args){
	}
	class Solution {
		public int[] solution(int[] arr) {
			int[] answer = new int[arr.length];
			for (int i=0; i<arr.length; i++) {
				if (arr[i] >= 50 && arr[i] % 2 == 0) answer[i] = arr[i]/2;
				else if (arr[i] < 50 && arr[i] % 2 == 1) answer[i] = arr[i]*2;
				else answer[i] = arr[i];
			}
			return answer;
		}
	}
}
